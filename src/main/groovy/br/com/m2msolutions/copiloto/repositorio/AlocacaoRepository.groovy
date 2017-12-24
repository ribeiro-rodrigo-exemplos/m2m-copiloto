package br.com.m2msolutions.copiloto.repositorio

import br.com.m2msolutions.copiloto.helpers.hazelcast.mapping.AlocacaoMapping
import br.com.m2msolutions.copiloto.helpers.hazelcast.portable.AlocacaoPortable
import br.com.m2msolutions.copiloto.modelo.viagem.Alocacao
import com.hazelcast.core.HazelcastInstance
import com.hazelcast.core.IMap
import com.hazelcast.query.Predicate
import com.hazelcast.query.PredicateBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import javax.annotation.PostConstruct

@Repository
class AlocacaoRepository {

    @Autowired
    HazelcastInstance hazelcastInstance
    @Autowired
    AlocacaoMapping alocacaoMapping

    private IMap<String,AlocacaoPortable> mapa

    private static String ALOCACAO_CACHE = 'alocacao'

    Alocacao obterAlocacaoDaViagem(String viagemId){

        Predicate predicate = new PredicateBuilder()
                                        .getEntryObject()
                                        .get('viagemId')
                                        .equal(viagemId)

        def portables = mapa.values predicate

        portables ? alocacaoMapping.map(portables[0]) : null
    }

    @PostConstruct
    private void obterMapa(){
        mapa = hazelcastInstance.getMap ALOCACAO_CACHE
    }
}
