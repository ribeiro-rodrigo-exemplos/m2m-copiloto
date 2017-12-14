package br.com.m2msolutions.copiloto.modelo.viagem

import br.com.m2msolutions.copiloto.helpers.DateHelper
import groovy.time.TimeDuration

class Regulagem {

    TimeDuration tempoRegulado
    Date momentoDaRegulagem = new Date()

    private DateHelper dateUtil

    Integer tempoReguladoEmMinutos(){
        dateUtil.obterDuracaosEmMinutos tempoRegulado
    }

    Double tempoReguladoEmMinutosESegundos(){
        dateUtil.obterMinutosESegundosEmNumeroReal tempoRegulado
    }
}
