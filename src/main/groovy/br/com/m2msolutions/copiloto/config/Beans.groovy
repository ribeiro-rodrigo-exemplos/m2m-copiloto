package br.com.m2msolutions.copiloto.config

import br.com.m2msolutions.copiloto.led.CopilotoLed
import com.google.common.eventbus.AsyncEventBus
import com.google.common.eventbus.EventBus
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import java.util.concurrent.Executors

@Configuration
class Beans{

    @Bean
    @ConfigurationProperties('redis')
    CopilotoLed copilotoLed(){
        new CopilotoLed()
    }

    @Bean
    EventBus eventBus(){
        new AsyncEventBus(
                Executors.newFixedThreadPool(
                        Runtime.getRuntime().availableProcessors() + 6
                )
        )
    }
}
