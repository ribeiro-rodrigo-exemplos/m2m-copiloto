package br.com.m2msolutions.copiloto.modelo.viagem

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = 'VeiculosEmViagem')
class Viagem implements Serializable {

    @Field('idViagemAtual')
    String idViagem
    @Field('idVeiculo')
    Integer idVeiculo
    @Field('dtAberturaViagem')
    Date momentoDaAbertura
    @Field('planejada')
    Alocacao alocacao
    @Field('estadoAtual')
    Integer estado
    @Field("tipo")
    Integer tipo

}
