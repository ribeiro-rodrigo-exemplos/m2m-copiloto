package br.com.m2msolutions.copiloto.modelo.regulacao

import br.com.m2msolutions.copiloto.helpers.DateHelper
import br.com.m2msolutions.copiloto.modelo.regulacao.TipoRegulacao
import com.fasterxml.jackson.annotation.JsonFormat
import groovy.time.TimeDuration

class Regulagem {

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = 'yyyy-MM-dd HH:mm:ss')
    Date momentoDaRegulagem = new Date()
    TimeDuration tempoRegulado
    TipoRegulacao tipoRegulacao

    private DateHelper dateHelper

    Double getTempoRegulado(){
        dateHelper.obterMinutosESegundosEmNumeroReal tempoRegulado
    }
}
