package br.com.m2msolutions.copiloto.config

import com.hazelcast.client.HazelcastClient
import com.hazelcast.client.config.ClientConfig
import com.hazelcast.core.HazelcastInstance
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by rodrigo on 23/11/17.
 */
@Configuration
@ConfigurationProperties(prefix = 'hazelcast')
class HazelcastConfig {

    def cacheInstances = []

    @Bean
    ClientConfig clientConfig(){

        def config = new ClientConfig()

        config.getNetworkConfig()
                    .addAddress(*cacheInstances)

        config.getGroupConfig()
                .setName("dev")
                .setPassword("dev-pass")

        config
    }

    @Bean
    HazelcastInstance hazelcastCacheInstance(){
        HazelcastClient.newHazelcastClient(clientConfig())
    }
}
