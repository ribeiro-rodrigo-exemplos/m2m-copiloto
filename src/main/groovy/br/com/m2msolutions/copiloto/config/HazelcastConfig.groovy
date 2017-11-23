package br.com.m2msolutions.copiloto.config

import com.hazelcast.config.Config
import com.hazelcast.config.EvictionPolicy
import com.hazelcast.config.MapConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by rodrigo on 23/11/17.
 */
@Configuration
class HazelcastConfig {

    static final String ALOCACAO_CACHE = 'alocacao'

    @Bean
    Config hazelcastConfig(){
        new Config()
                .addMapConfig(
                    new MapConfig()
                        .setName(ALOCACAO_CACHE)
                        .setEvictionPolicy(EvictionPolicy.LRU)
                        .setTimeToLiveSeconds(2400)
        )
    }
}
