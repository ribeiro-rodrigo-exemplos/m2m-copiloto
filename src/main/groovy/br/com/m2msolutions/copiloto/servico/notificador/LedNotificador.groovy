package br.com.m2msolutions.copiloto.servico.notificador

import br.com.m2msolutions.copiloto.led.CopilotoLed
import br.com.m2msolutions.copiloto.modelo.regulacao.RegulagemEvent
import br.com.m2msolutions.copiloto.repositorio.StatusRepository
import com.google.common.eventbus.EventBus
import com.google.common.eventbus.Subscribe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct
import java.util.concurrent.TimeUnit

@Service
class LedNotificador {

    @Autowired
    CopilotoLed copilotoLed
    @Autowired
    StatusRepository statusRepository
    @Autowired
    EventBus eventBus
    @Value('${copiloto-led.minutos-de-iluminacao}')
    private Integer minutosDeIluminacao

    @Subscribe
    void enviarRegulagem(RegulagemEvent evento){

        if(naoDeveEnviarComando(evento))
            return

        copilotoLed.enviarComando(
            evento.veiculo?.clienteId,
            evento.veiculo?.veiculoId,
            evento.veiculo?.modulo?.modelo,
            evento.veiculo?.modulo?.identificador,
            evento.regulagem.tempoReguladoEmMinutos,
            minutosDeIluminacao
        )

        statusRepository.salvarCodigoDeStatusDoVeiculo(
            evento.veiculo.veiculoId,
            obterCodigoDeStatus(evento),
            minutosDeIluminacao.minus(1).longValue(),
            TimeUnit.MINUTES
        )
    }

    private Boolean naoDeveEnviarComando(RegulagemEvent evento){

        def ultimoCodigoDeStatus = statusRepository.obterUltimoCodigoDeStatusDoVeiculo evento.veiculo.veiculoId
        def codigoDeStatusDaRegulagemAtual = obterCodigoDeStatus evento

        codigoDeStatusDaRegulagemAtual == ultimoCodigoDeStatus
    }

    private String obterCodigoDeStatus(RegulagemEvent evento){
        copilotoLed.obterCodigoDeStatus evento.regulagem.tempoReguladoEmMinutos
    }

    @PostConstruct
    private void init(){
        eventBus.register this
    }
}
