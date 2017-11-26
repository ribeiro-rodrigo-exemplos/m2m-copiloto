package br.com.m2msolutions.copiloto.modelo.planejamento

import br.com.m2msolutions.copiloto.modelo.Regulacao
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.helpers.DateHelper
import groovy.time.TimeCategory
import groovy.time.TimeDuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class RegulacaoPorPlanejamento implements Regulacao {

    @Autowired
    DateHelper dateUtil

    @Override
    TimeDuration regular(MomentoViagem situacaoViagem) {

        if(!situacaoViagem.alocacao)
            return null

        def momentoDaPartida = situacaoViagem.alocacao.momentoDaPartida
        def momentoPlanejadoDaChegada = situacaoViagem.alocacao.chegadaPlanejada
        def percentualConclusao = situacaoViagem.percentualDeConclusao
        def momentoDaTransmissao = situacaoViagem.momentoDaTransmissao

        def duracaoEstimadaDoTrajeto = calcularDuracaoEstimadaDoTrajeto momentoDaPartida, momentoPlanejadoDaChegada

        def tempoGastoIdeal = calcularTempoGastoIdeal percentualConclusao, duracaoEstimadaDoTrajeto

        def tempoGasto =  calcularTempoGastoNoTrajeto momentoDaPartida, momentoDaTransmissao

        dateUtil.calcularDiferenca tempoGasto, tempoGastoIdeal
    }

    private TimeDuration calcularDuracaoEstimadaDoTrajeto(Date dataHoraPartida, Date dataHoraChegadaPlanejada){
        dateUtil.calcularDiferenca dataHoraPartida,dataHoraChegadaPlanejada
    }

    private TimeDuration calcularTempoGastoIdeal(Float percentualConclusao, TimeDuration duracaoEstimadaDoTrajeto){

        def tempoTotalEmMinutos = dateUtil.obterDuracaosEmMinutos duracaoEstimadaDoTrajeto
        def tempoIdealParaPosicao = (percentualConclusao / 100 ) * tempoTotalEmMinutos

        def round = Math.round(tempoIdealParaPosicao) as Integer

        use(TimeCategory){
            round.minutes
        }
    }

    private TimeDuration calcularTempoGastoNoTrajeto(Date dataHoraPartida,Date dataHoraTransmissao){
        dateUtil.calcularDiferenca dataHoraPartida, dataHoraTransmissao
    }
}
