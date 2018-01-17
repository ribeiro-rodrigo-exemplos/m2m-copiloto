package br.com.m2msolutions.copiloto

import br.com.m2msolutions.copiloto.infra.grpc.GrpcServer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

@Component
class Bootstrap implements CommandLineRunner{

    @Autowired
    GrpcServer server

    @Override
    void run(String... args) throws Exception {
        server.start()
    }

    @PostConstruct
    void setting(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }

    @PreDestroy
    void shutdown(){
        server.stop()
    }
}
