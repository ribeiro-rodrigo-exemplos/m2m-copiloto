package br.com.m2msolutions.copiloto.modelo.regulacao

import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import groovy.time.TimeDuration

trait Regulacao {
    abstract TimeDuration regular(MomentoViagem momento)
    abstract TipoRegulacao obterTipo()
}