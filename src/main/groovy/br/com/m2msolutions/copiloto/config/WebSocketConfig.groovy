package br.com.m2msolutions.copiloto.config

import br.com.m2msolutions.copiloto.infra.websocket.WebSocket
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private WebSocket webSocket

    @Override
    void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocket,"/copiloto/{veiculo}").setAllowedOrigins("*")
    }
}
