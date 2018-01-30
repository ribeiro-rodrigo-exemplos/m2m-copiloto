package br.com.m2msolutions.copiloto.servico.notificador

import br.com.m2msolutions.copiloto.led.CopilotoLed
import br.com.m2msolutions.copiloto.modelo.regulacao.RegulagemEvent
import br.com.m2msolutions.copiloto.repositorio.StatusRepository
import com.google.common.eventbus.EventBus
import com.google.common.eventbus.Subscribe
import org.slf4j.Logger
import org.slf4j.LoggerFactory
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

    private final Logger logger = LoggerFactory.getLogger(getClass())

    @Subscribe
    void enviarRegulagem(RegulagemEvent evento){

        try{

            if(naoDeveEnviarComando(evento))
                return

            logger.info "Enviando comando ao veiculo ${evento.veiculo.veiculoId}"

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
        catch (e){
            logger.error "Erro ao enviar comando ao veiculo ${evento.veiculo.veiculoId}"
        }

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
