package br.com.m2msolutions.copiloto.servico.notificador

import br.com.m2msolutions.copiloto.helpers.JsonHelper
import br.com.m2msolutions.copiloto.infra.websocket.NovaSessaoWebSocketEvent
import br.com.m2msolutions.copiloto.infra.websocket.WebSocket
import br.com.m2msolutions.copiloto.modelo.regulacao.RegulagemEvent
import br.com.m2msolutions.copiloto.repositorio.RegulagemRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class WebNotificador{

    @Autowired
    JsonHelper jsonHelper
    @Autowired
    WebSocket webSocket
    @Autowired
    RegulagemRepository regulagemRepository

    private final Logger logger = LoggerFactory.getLogger(getClass())

    @EventListener
    void enviarRegulagem(RegulagemEvent evento){

        logger.info "Enviando regulagem para a sessao do veiculo ${evento?.veiculo?.veiculoId}"

        def objetoSerializado = jsonHelper.serializar evento
        webSocket.enviarMensagem evento?.veiculo?.veiculoId, objetoSerializado
    }

    @EventListener
    void enviarUltimaRegulagem(NovaSessaoWebSocketEvent evento){
        RegulagemEvent regulagemEvent = regulagemRepository.obterUltimaRegulagemDoVeiculo evento.veiculoId
        enviarRegulagem regulagemEvent
    }
}
