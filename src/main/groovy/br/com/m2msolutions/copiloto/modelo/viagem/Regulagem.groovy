package br.com.m2msolutions.copiloto.modelo.viagem

import br.com.m2msolutions.copiloto.util.DateUtil
import groovy.time.TimeDuration

class Regulagem {

    TimeDuration tempoRegulado

    private Boolean prumo
    private DateUtil dateUtil

    Integer tempoReguladoEmMinutos(){
        dateUtil.obterDuracaosEmMinutos tempoRegulado
    }

    Boolean getPrumo(){
        (-1..1).contains(tempoReguladoEmMinutos())
    }
}
