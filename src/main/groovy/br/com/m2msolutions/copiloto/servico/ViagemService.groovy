package br.com.m2msolutions.copiloto.servico

import br.com.m2msolutions.copiloto.helpers.hazelcast.mapping.AlocacaoMapping
import br.com.m2msolutions.copiloto.helpers.hazelcast.portable.AlocacaoPortable
import br.com.m2msolutions.copiloto.modelo.viagem.Alocacao
import com.hazelcast.core.HazelcastInstance
import com.hazelcast.core.IMap
import com.hazelcast.query.Predicate
import com.hazelcast.query.PredicateBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct

@Service
class ViagemService {

    @Autowired
    HazelcastInstance hazelcastInstance
    @Autowired
    AlocacaoMapping alocacaoMapping

    private IMap<String,AlocacaoPortable> mapa

    private static String ALOCACAO_CACHE = "alocacao"

    Alocacao obterAlocacaoDoVeiculo(Integer veiculoId){

        Predicate predicate = new PredicateBuilder()
                                        .getEntryObject()
                                            .get('idVeiculo')
                                        .equal(veiculoId)

        def portables = mapa.values predicate

        portables ? alocacaoMapping.map(portables[0]) : null
    }

    @PostConstruct
    private void obterMapa(){
        mapa = hazelcastInstance.getMap ALOCACAO_CACHE
    }
}
