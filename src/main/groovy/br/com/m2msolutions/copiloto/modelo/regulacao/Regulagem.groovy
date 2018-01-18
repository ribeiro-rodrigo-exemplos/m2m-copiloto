package br.com.m2msolutions.copiloto.modelo.regulacao

class Regulagem implements Serializable {

    private TipoRegulacao tipoRegulacao
    private Double tempoRegulado

    TipoRegulacao getTipoRegulacao(){
        tipoRegulacao
    }

    Double getTempoRegulado(){
        tempoRegulado
    }

    Integer getTempoReguladoEmMinutos(){
        tempoRegulado?.toInteger()
    }
}
