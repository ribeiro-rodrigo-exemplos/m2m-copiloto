package br.com.m2msolutions.copiloto.servico

import br.com.m2msolutions.copiloto.modelo.Trajeto
import br.com.m2msolutions.copiloto.repositorio.TrajetoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TrajetoService {

    @Autowired
    TrajetoRepository trajetoRepository

    Trajeto obterTrajeto(String linhaId,String trajetoId){
        trajetoRepository.obterTrajeto linhaId, trajetoId
    }
}
