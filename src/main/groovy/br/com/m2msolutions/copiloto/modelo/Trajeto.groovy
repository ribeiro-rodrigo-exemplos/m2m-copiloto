package br.com.m2msolutions.copiloto.modelo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document
class Trajeto {

    @Id
    String trajetoId
    @Field("copilotoAlgoritmo")
    TipoRegulacao tipoRegulacao
}
