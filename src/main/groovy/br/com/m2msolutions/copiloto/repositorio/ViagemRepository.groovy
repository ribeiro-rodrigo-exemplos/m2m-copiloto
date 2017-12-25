package br.com.m2msolutions.copiloto.repositorio

import br.com.m2msolutions.copiloto.modelo.viagem.Viagem
import org.springframework.data.mongodb.repository.MongoRepository

interface ViagemRepository extends MongoRepository<Viagem,String> {
    Viagem findByIdViagem(String idViagem)
}