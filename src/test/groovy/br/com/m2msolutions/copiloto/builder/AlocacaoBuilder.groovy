package br.com.m2msolutions.copiloto.builder

import br.com.m2msolutions.copiloto.modelo.viagem.Alocacao
import groovy.time.TimeCategory

class AlocacaoBuilder {

    private alocacao = new Alocacao()

    AlocacaoBuilder planejadaPara(Date date){
        alocacao.partidaPlanejada = date
        this
    }

    AlocacaoBuilder iniciouComMinutosDeAtraso(Integer atraso){
        use(TimeCategory){
            alocacao.momentoDaPartida = alocacao.partidaPlanejada.clone()
            alocacao.momentoDaPartida = alocacao.momentoDaPartida + atraso.minutes
            this
        }
    }

    AlocacaoBuilder iniciouEm(Date data){
        alocacao.momentoDaPartida = data
        this
    }

    AlocacaoBuilder comHorarioId(Integer horarioId){
        alocacao.horarioId = horarioId
        this
    }

    AlocacaoBuilder comMinutosDeDuracao(Integer duracao){
        use(TimeCategory){
            alocacao.chegadaPlanejada = alocacao.partidaPlanejada.clone() as Date
            alocacao.chegadaPlanejada = alocacao.partidaPlanejada + duracao.minutes
            this
        }
    }

    Alocacao criar(){
        alocacao
    }
}
