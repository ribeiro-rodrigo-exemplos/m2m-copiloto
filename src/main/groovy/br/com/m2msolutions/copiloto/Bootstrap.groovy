package br.com.m2msolutions.copiloto

import br.com.m2msolutions.copiloto.modelo.Linha
import br.com.m2msolutions.copiloto.modelo.Trajeto
import br.com.m2msolutions.copiloto.repositorio.TrajetoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

/**
 * Created by rodrigo on 23/11/17.
 */
@Component
class Bootstrap implements CommandLineRunner{

    @Autowired
    TrajetoRepository trajetoRepository

    @Override
    void run(String... args) throws Exception {

        Trajeto trajeto = trajetoRepository.obterTrajeto("56eabf2ba67c3eea7a212ec6","56eabf2ba67c3eea7a212ec5")

        println trajeto?.properties
    }
}
