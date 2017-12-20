package br.com.m2msolutions.copiloto.modelo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Linha")
class Linha {

    @Id
    String id
    List<Trajeto> trajetos
}
