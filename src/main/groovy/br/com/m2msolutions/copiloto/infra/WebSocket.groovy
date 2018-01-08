package br.com.m2msolutions.copiloto.infra

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession
import java.util.concurrent.CopyOnWriteArrayList

@Component
class WebSocket implements WebSocketHandler {

    private final sessionsMap = [:]

    private final Logger logger = LoggerFactory.getLogger(getClass())

    void enviarMensagem(Integer veiculoId,String mensagem){

        def sessionsList = sessionsMap[veiculoId] as CopyOnWriteArrayList

        def iterator = sessionsList?.iterator()

        iterator?.each {
            WebSocketSession session ->
                try{
                    if (session.isOpen())
                        session.sendMessage(new TextMessage(mensagem))
                }
                catch (e){
                    logger.error "Erro ao enviar mensagem para o veiculo ${veiculoId} - ${e.message}"
                }
        }
    }

    @Override
    void afterConnectionEstablished(WebSocketSession session) throws Exception {

        logger.info "Sessão WebSocket iniciada ${session.id}, URI: ${session.uri.path}"

        def idVeiculo = obterIdDoVeiculo session.uri.path

        session.attributes['idVeiculo'] = idVeiculo

        if(idVeiculo)
            adicionarSessao(idVeiculo,session)
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
        removerSessao session
    }

    @Override
    boolean supportsPartialMessages() {
        return false
    }

    private void removerSessao(WebSocketSession session){
        synchronized (sessionsMap){

            def sessionsList = sessionsMap[session.attributes['idVeiculo']] as List
            sessionsList.remove session

            if(!sessionsList)
                sessionsMap.remove(session.attributes['idVeiculo'])
        }
    }

    private void adicionarSessao(Integer idVeiculo,WebSocketSession session){

        synchronized (sessionsMap){
            if(!sessionsMap[idVeiculo])
                sessionsMap[idVeiculo] = new CopyOnWriteArrayList<WebSocketSession>()

            sessionsMap[idVeiculo] << session
        }
    }

    private Integer obterIdDoVeiculo(String path){
        def url = path.split('/')
        url.size() == 3 ? url[2] as Integer : null
    }
}
