package br.com.m2msolutions.copiloto.builder

import br.com.m2msolutions.copiloto.modelo.viagem.Alocacao
import br.com.m2msolutions.copiloto.modelo.viagem.Viagem
import groovy.time.TimeCategory

class ViagemBuilder {

    private viagem = new Viagem()

    ViagemBuilder planejadaPara(Date date){

        criarAlocacao viagem
        viagem.alocacao.partidaPlanejada = date
        this
    }

    ViagemBuilder iniciouComMinutosDeAtraso(Integer atraso){

        criarAlocacao viagem

        use(TimeCategory){
            viagem.momentoDaAbertura = viagem.alocacao.partidaPlanejada.clone() as Date
            viagem.momentoDaAbertura = viagem.momentoDaAbertura + atraso.minutes
            this
        }
    }

    ViagemBuilder iniciouEm(Date data){
        viagem.momentoDaAbertura = data
        this
    }

    ViagemBuilder comMinutosDeDuracao(Integer duracao){

        criarAlocacao viagem

        use(TimeCategory){
            viagem.alocacao.chegadaPlanejada = viagem.alocacao.partidaPlanejada.clone() as Date
            viagem.alocacao.chegadaPlanejada = viagem.alocacao.partidaPlanejada + duracao.minutes
            this
        }
    }

    Viagem criar(){
        viagem
    }

    private void criarAlocacao(Viagem viagem){
        if(!viagem.alocacao)
            viagem.alocacao = new Alocacao()
    }
}
