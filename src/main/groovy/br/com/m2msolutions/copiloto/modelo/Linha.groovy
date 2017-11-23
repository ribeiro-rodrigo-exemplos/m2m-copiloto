package br.com.m2msolutions.copiloto.modelo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


/**
 * Created by rodrigo on 23/11/17.
 */
@Document(collection = "Linha")
class Linha {

    @Id
    String id
    List<Trajeto> trajetos
}
