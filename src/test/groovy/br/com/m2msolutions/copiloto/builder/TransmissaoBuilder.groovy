package br.com.m2msolutions.copiloto.builder

import br.com.m2msolutions.copiloto.modelo.viagem.Viagem
import groovy.time.TimeCategory

class TransmissaoBuilder {

    private Viagem viagem

    TransmissaoBuilder emViagem(Viagem viagem){
        this.viagem = viagem
        this
    }

    Date transmitiuAposTempoDeViagem(Integer minutosTramissao,Integer segundosTransmissao = 0){
        use(TimeCategory){
            viagem.momentoDaAbertura + minutosTramissao.minutes + segundosTransmissao.seconds
        }
    }
}
