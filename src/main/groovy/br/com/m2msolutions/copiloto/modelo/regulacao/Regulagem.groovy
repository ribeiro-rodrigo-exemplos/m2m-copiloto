package br.com.m2msolutions.copiloto.modelo.regulacao

import br.com.m2msolutions.copiloto.helpers.DateHelper
import br.com.m2msolutions.copiloto.modelo.regulacao.TipoRegulacao
import com.fasterxml.jackson.annotation.JsonFormat
import groovy.time.TimeDuration

class Regulagem {
    TimeDuration tempoRegulado
    TipoRegulacao tipoRegulacao

    private DateHelper dateHelper

    Double getTempoRegulado(){
        dateHelper.obterMinutosESegundosEmNumeroReal tempoRegulado
    }
}
