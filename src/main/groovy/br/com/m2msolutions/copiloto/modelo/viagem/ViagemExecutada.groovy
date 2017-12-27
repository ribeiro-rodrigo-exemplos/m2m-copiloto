package br.com.m2msolutions.copiloto.modelo.viagem

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = 'ViagemExecutada')
class ViagemExecutada {

    @Id
    String id
    @Field('executada.dataInicio')
    Date dataInicio
}
