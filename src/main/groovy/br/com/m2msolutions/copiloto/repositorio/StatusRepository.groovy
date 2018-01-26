package br.com.m2msolutions.copiloto.repositorio

import com.hazelcast.core.HazelcastInstance
import com.hazelcast.core.IMap
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository

import javax.annotation.PostConstruct
import java.util.concurrent.TimeUnit

@Repository
class StatusRepository {

    @Autowired
    @Qualifier("hazelcastCacheInstance")
    HazelcastInstance hazelcastInstance
    IMap<Integer,String> mapa

    String obterUltimoCodigoDeStatusDoVeiculo(Integer veiculoId){
        mapa.get veiculoId
    }

    void salvarCodigoDeStatusDoVeiculo(Integer veiculoId,String codigoStatus, Long ttl, TimeUnit unidadeDeTempo = TimeUnit.MINUTES){
        mapa.put veiculoId, codigoStatus, ttl, unidadeDeTempo
    }

    @PostConstruct
    private void init(){
        mapa = hazelcastInstance.getMap "ultimoStatusVeiculo"
    }
}
