package br.com.m2msolutions.copiloto.builder

import br.com.m2msolutions.copiloto.modelo.viagem.Alocacao
import groovy.time.TimeCategory

class TransmissaoBuilder {

    private Alocacao alocacao

    TransmissaoBuilder emViagemComAlocacao(Alocacao alocacao){
        this.alocacao = alocacao
        this
    }

    Date transmitiuAposTempoDeViagem(Integer minutosTramissao,Integer segundosTransmissao = 0){
        use(TimeCategory){
            alocacao.momentoDaPartida + minutosTramissao.minutes + segundosTransmissao.seconds
        }
    }
}
