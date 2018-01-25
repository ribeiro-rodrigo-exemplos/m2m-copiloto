package br.com.m2msolutions.copiloto.servico.notificador

import br.com.m2msolutions.copiloto.led.CopilotoLed
import br.com.m2msolutions.copiloto.modelo.regulacao.RegulagemEvent
import com.google.common.eventbus.EventBus
import com.google.common.eventbus.Subscribe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct

@Service
class LedNotificador {

    @Autowired
    CopilotoLed copilotoLed
    @Autowired
    EventBus eventBus
    @Value('${copiloto-led.minutos-de-iluminacao}')
    private Integer minutosDeIluminacao

    @Subscribe
    void enviarRegulagem(RegulagemEvent evento){

        copilotoLed.enviarComando(
                evento.veiculo?.clienteId,
                evento.veiculo?.veiculoId,
                evento.veiculo?.modulo?.modelo,
                evento.veiculo?.modulo?.identificador,
                evento.regulagem.tempoReguladoEmMinutos
        )
    }

    @PostConstruct
    private void init(){
        eventBus.register this
    }
}
