package br.com.m2msolutions.copiloto.config

import br.com.m2msolutions.copiloto.servico.WebSocketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private WebSocketService service

    @Override
    void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(service,"/copiloto/{veiculo}").setAllowedOrigins("*")
    }
}
