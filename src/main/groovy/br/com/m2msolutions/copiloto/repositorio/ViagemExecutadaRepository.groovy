package br.com.m2msolutions.copiloto.repositorio

import br.com.m2msolutions.copiloto.modelo.viagem.ViagemExecutada
import org.springframework.data.mongodb.repository.MongoRepository

interface ViagemExecutadaRepository extends MongoRepository<ViagemExecutada,String> {

}