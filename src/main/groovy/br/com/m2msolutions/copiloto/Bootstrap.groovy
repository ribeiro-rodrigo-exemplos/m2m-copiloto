package br.com.m2msolutions.copiloto

import br.com.m2msolutions.copiloto.helpers.DateHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import javax.annotation.PreDestroy

@Component
class Bootstrap implements CommandLineRunner{

    @Autowired
    GrpcServer server
    @Autowired
    DateHelper dateHelper

    @Override
    void run(String... args) throws Exception {
        server.start()

        //println dateHelper.obterDuracao(1.99)

    }

    @PreDestroy
    void shutdown(){
        server.stop()
    }
}
