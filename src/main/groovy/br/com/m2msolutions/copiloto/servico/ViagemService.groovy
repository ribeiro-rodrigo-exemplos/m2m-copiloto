package br.com.m2msolutions.copiloto.servico

import br.com.m2msolutions.copiloto.helpers.hazelcast.mapping.AlocacaoMapping
import br.com.m2msolutions.copiloto.helpers.hazelcast.portable.AlocacaoPortable
import br.com.m2msolutions.copiloto.modelo.viagem.Alocacao
import com.hazelcast.core.HazelcastInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ViagemService {

    @Autowired
    HazelcastInstance hazelcastInstance
    @Autowired
    AlocacaoMapping alocacaoMapping

    private static String ALOCACAO_CACHE = "alocacao"

    Alocacao obterAlocacaoDoVeiculo(Integer veiculoId){

        def mapa = hazelcastInstance.getMap ALOCACAO_CACHE
        def portable = mapa.get(veiculoId) as AlocacaoPortable

        portable ? alocacaoMapping.map(portable) : null
    }
}
