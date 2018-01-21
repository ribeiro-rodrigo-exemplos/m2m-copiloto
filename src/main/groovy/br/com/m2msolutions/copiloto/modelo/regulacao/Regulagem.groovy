package br.com.m2msolutions.copiloto.modelo.regulacao

import com.fasterxml.jackson.annotation.JsonIgnore

class Regulagem implements Serializable {

    private TipoRegulacao tipoRegulacao
    private Double tempoRegulado

    TipoRegulacao getTipoRegulacao(){
        tipoRegulacao
    }

    Double getTempoRegulado(){
        tempoRegulado
    }

    @JsonIgnore
    Integer getTempoReguladoEmMinutos(){
        tempoRegulado?.toInteger()
    }
}
