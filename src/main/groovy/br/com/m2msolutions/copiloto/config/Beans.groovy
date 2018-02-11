package br.com.m2msolutions.copiloto.config

import br.com.m2msolutions.copiloto.led.CopilotoLed
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Beans{

    @Bean
    @ConfigurationProperties('copiloto-led.redis')
    CopilotoLed copilotoLed(){
        new CopilotoLed()
    }
}
