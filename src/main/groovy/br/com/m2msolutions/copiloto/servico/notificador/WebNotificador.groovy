package br.com.m2msolutions.copiloto.servico.notificador

import br.com.m2msolutions.copiloto.helpers.JsonHelper
import br.com.m2msolutions.copiloto.infra.WebSocket
import br.com.m2msolutions.copiloto.modelo.evento.RegulagemEvent
import com.google.common.eventbus.EventBus
import com.google.common.eventbus.Subscribe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class WebNotificador{

    @Autowired
    JsonHelper jsonHelper
    @Autowired
    WebSocket webSocket
    @Autowired
    EventBus eventBus

    @Subscribe
    void enviarRegulagem(RegulagemEvent evento){

        def objetoSerializado = jsonHelper.serializar evento
        webSocket.enviarMensagem evento?.veiculo?.veiculoId, objetoSerializado
    }

    @PostConstruct
    private void init(){
        eventBus.register this
    }
}
