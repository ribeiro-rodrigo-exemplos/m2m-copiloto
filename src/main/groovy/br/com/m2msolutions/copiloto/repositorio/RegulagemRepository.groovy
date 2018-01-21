package br.com.m2msolutions.copiloto.repositorio

import br.com.m2msolutions.copiloto.modelo.regulacao.RegulagemEvent
import com.hazelcast.core.HazelcastInstance
import com.hazelcast.core.IMap
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository

import javax.annotation.PostConstruct

@Repository
class RegulagemRepository {

    @Autowired
    @Qualifier("hazelcastCacheInstance")
    HazelcastInstance hazelcastInstance
    IMap<Integer,RegulagemEvent> mapa

    void salvar(RegulagemEvent evento){
        mapa.put evento.veiculo.veiculoId,evento
    }

    void remover(Integer veiculoId){
        mapa.remove veiculoId
    }

    RegulagemEvent obterUltimaRegulagemDoVeiculo(Integer veiculoId){
        mapa.get veiculoId
    }

    @PostConstruct
    private void init(){
        mapa = hazelcastInstance.getMap "ultimaRegulagem"
    }
}
