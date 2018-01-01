package br.com.m2msolutions.copiloto.modelo

import br.com.m2msolutions.copiloto.modelo.regulacao.TipoRegulacao
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document
class Trajeto implements Serializable {

    @Id
    String trajetoId
    @Field("copilotoAlgoritmo")
    TipoRegulacao tipoRegulacao
}
