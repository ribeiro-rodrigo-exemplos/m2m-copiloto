package br.com.m2msolutions.copiloto.servico

import br.com.m2msolutions.copiloto.modelo.viagem.Viagem
import br.com.m2msolutions.copiloto.repositorio.ViagemRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ViagemService {

    @Autowired
    ViagemRepository viagemRepository

    private final Logger logger = LoggerFactory.getLogger(getClass())

    Viagem obterViagem(String viagemId){

        def viagem = viagemRepository.findByIdViagem viagemId

        if(!viagem)
            logger.warn "Viagem ${viagemId} nao encontrada."

        viagem
    }
}
