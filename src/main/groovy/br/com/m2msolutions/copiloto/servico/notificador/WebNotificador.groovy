package br.com.m2msolutions.copiloto.servico.notificador

import br.com.m2msolutions.copiloto.helpers.JsonHelper
import br.com.m2msolutions.copiloto.infra.websocket.NovaSessaoWebSocketEvent
import br.com.m2msolutions.copiloto.infra.websocket.WebSocket
import br.com.m2msolutions.copiloto.modelo.regulacao.RegulagemEvent
import br.com.m2msolutions.copiloto.repositorio.RegulagemRepository
import com.google.common.eventbus.EventBus
import com.google.common.eventbus.Subscribe
import org.slf4j.Logger
import org.slf4j.LoggerFactory
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
    @Autowired
    RegulagemRepository regulagemRepository

    private final Logger logger = LoggerFactory.getLogger(getClass())

    @Subscribe
    void enviarRegulagem(RegulagemEvent evento){

        logger.info "Enviando regulagem para a sessao do veiculo ${evento.veiculo.veiculoId}"

        def objetoSerializado = jsonHelper.serializar evento
        webSocket.enviarMensagem evento?.veiculo?.veiculoId, objetoSerializado
    }

    @Subscribe
    void enviarUltimaRegulagem(NovaSessaoWebSocketEvent evento){
        RegulagemEvent regulagemEvent = regulagemRepository.obterUltimaRegulagemDoVeiculo evento.veiculoId
        enviarRegulagem regulagemEvent
    }

    @PostConstruct
    private void init(){
        eventBus.register this
    }
}
