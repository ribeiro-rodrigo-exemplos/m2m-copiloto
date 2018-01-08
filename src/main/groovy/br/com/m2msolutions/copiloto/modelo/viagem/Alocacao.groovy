package br.com.m2msolutions.copiloto.modelo.viagem

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document
class Alocacao implements Serializable{

    @Field('dataInicio')
    Date partidaPlanejada
    @Field('dataFim')
    Date chegadaPlanejada
}
