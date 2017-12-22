package br.com.m2msolutions.copiloto.modelo.viagem

import br.com.m2msolutions.copiloto.helpers.DateHelper
import br.com.m2msolutions.copiloto.helpers.NumberHelper
import groovy.time.TimeDuration

class Regulagem {

    TimeDuration tempoRegulado
    Date momentoDaRegulagem = new Date()

    private DateHelper dateUtil
    private NumberHelper numberHelper

    Integer tempoReguladoEmMinutos(){
        dateUtil.obterDuracaosEmMinutos tempoRegulado
    }

    Double tempoReguladoEmMinutosESegundos(){

        if(numberHelper.ehNegativo(tempoRegulado.seconds)){
            def tempo = dateUtil.obterMinutosESegundosEmNumeroReal tempoRegulado
            def timeDuration = dateUtil.obterDuracao(tempo as BigDecimal)
            return dateUtil.obterMinutosESegundosEmNumeroReal(timeDuration)
        }

        dateUtil.obterMinutosESegundosEmNumeroReal tempoRegulado
    }
}
