package br.com.m2msolutions.copiloto.servico

import br.com.m2msolutions.copiloto.modelo.viagem.Regulagem
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession

@Component
class WebSocketService implements WebSocketHandler {

    def sessions = [:]

    private final Logger logger = LoggerFactory.getLogger(getClass())

    void enviarRegulagem(Integer idVeiculo,Regulagem regulagem){
        try {
            def sessao = sessions[idVeiculo] as WebSocketSession
            if (sessao.isOpen())
                sessao.sendMessage(new TextMessage('regulagem realizada'))
        }
        catch (Exception e){
            println "${e} ---- "
        }

    }

    @Override
    void afterConnectionEstablished(WebSocketSession session) throws Exception {

        logger.info "Sessão WebSocket iniciada ${session.id}, URI: ${session.uri.path}"

        def idVeiculo = obterIdDoVeiculo session.uri.path

        if(idVeiculo)
            sessions[idVeiculo] = session
        else
            session.close(CloseStatus.NORMAL)
    }

    @Override
    void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        logger.info "Mensagem recebida ${message.class}"
    }

    @Override
    void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        logger.error "Erro na Sessão WebSocket ${session.id}, URI: ${session.uri.path}"
    }

    @Override
    void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        logger.info "Sessão WebSocket finalizada ${session.id}, URI: ${session.uri.path}, Status: ${closeStatus.code}"
    }

    @Override
    boolean supportsPartialMessages() {
        return false
    }

    private Integer obterIdDoVeiculo(String path){
        def url = path.split('/')
        url.size() == 3 ? url[2] as Integer : null
    }
}
