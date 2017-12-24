package br.com.m2msolutions.copiloto.modelo.viagem

import br.com.m2msolutions.copiloto.helpers.DateHelper
import br.com.m2msolutions.copiloto.helpers.NumberHelper
import groovy.time.TimeDuration

class Regulagem {

    TimeDuration tempoRegulado
    Date momentoDaRegulagem = new Date()

    private DateHelper dateHelper
    private NumberHelper numberHelper

    Integer tempoReguladoEmMinutos(){
        dateHelper.obterDuracaosEmMinutos tempoRegulado
    }

    Double tempoReguladoEmMinutosESegundos(){
        dateHelper.obterMinutosESegundosEmNumeroReal tempoRegulado
    }
}
