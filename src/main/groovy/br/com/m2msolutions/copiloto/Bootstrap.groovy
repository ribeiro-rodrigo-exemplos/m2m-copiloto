package br.com.m2msolutions.copiloto

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import javax.annotation.PreDestroy

@Component
class Bootstrap implements CommandLineRunner{

    @Autowired
    GrpcServer server

    @Override
    void run(String... args) throws Exception {
        server.start()
    }

    @PreDestroy
    void shutdown(){
        server.stop()
    }
}
