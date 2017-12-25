package br.com.m2msolutions.copiloto.modelo.planejamento

import br.com.m2msolutions.copiloto.modelo.Regulacao
import br.com.m2msolutions.copiloto.modelo.viagem.RegulagemException
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.helpers.DateHelper
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
            throw new RegulagemException('Não é possível regular por planejamento sem alocação')

        def momentoDaAbertura = situacaoViagem.viagem.momentoDaAbertura
        def momentoPlanejadoDaChegada = situacaoViagem.alocacao.chegadaPlanejada
        def percentualConclusao = situacaoViagem.percentualDeConclusao
        def momentoDaTransmissao = situacaoViagem.momentoDaTransmissao

        def duracaoEstimadaDoTrajeto = calcularDuracaoEstimadaDoTrajeto momentoDaAbertura, momentoPlanejadoDaChegada

        def tempoGastoIdeal = calcularTempoGastoIdeal percentualConclusao, duracaoEstimadaDoTrajeto

        def tempoGasto =  calcularTempoGastoNoTrajeto momentoDaAbertura, momentoDaTransmissao

        dateUtil.calcularDiferenca tempoGasto, tempoGastoIdeal
    }

    private TimeDuration calcularDuracaoEstimadaDoTrajeto(Date dataHoraPartida, Date dataHoraChegadaPlanejada){
        dateUtil.calcularDiferenca dataHoraPartida,dataHoraChegadaPlanejada
    }

    private TimeDuration calcularTempoGastoIdeal(BigDecimal percentualConclusao, TimeDuration duracaoEstimadaDoTrajeto){

        def tempoTotalEmMinutos = dateUtil.obterDuracaosEmMinutos duracaoEstimadaDoTrajeto
        def tempoIdealParaPosicao = (percentualConclusao / 100 ) * tempoTotalEmMinutos

        dateUtil.obterDuracao tempoIdealParaPosicao
    }

    private TimeDuration calcularTempoGastoNoTrajeto(Date dataHoraPartida,Date dataHoraTransmissao){
        dateUtil.calcularDiferenca dataHoraPartida, dataHoraTransmissao
    }
}
