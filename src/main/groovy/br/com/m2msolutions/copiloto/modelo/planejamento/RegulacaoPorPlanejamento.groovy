package br.com.m2msolutions.copiloto.modelo.planejamento

import br.com.m2msolutions.copiloto.modelo.Regulacao
import br.com.m2msolutions.copiloto.modelo.viagem.Alocacao
import br.com.m2msolutions.copiloto.modelo.viagem.Regulagem
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.util.DateUtil
import groovy.time.TimeCategory
import groovy.time.TimeDuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class RegulacaoPorPlanejamento implements Regulacao {

    @Autowired
    DateUtil dateUtil

    @Override
    TimeDuration regular(MomentoViagem situacaoViagem) {

        if(!situacaoViagem.alocacao)
            return null

        def dataHoraPartida = situacaoViagem.alocacao.momentoDaPartida
        def dataHoraChegadaPlanejada = situacaoViagem.alocacao.chegadaPlanejada
        def percentualConclusao = situacaoViagem.percentualDeConclusao
        def dataHoraTransmissao = situacaoViagem.momentoDaTransmissao

        def duracaoEstimadaDoTrajeto = calcularDuracaoEstimadaDoTrajeto dataHoraPartida, dataHoraChegadaPlanejada

        def tempoGastoPlanejado = calcularTempoGastoPlanejado percentualConclusao, duracaoEstimadaDoTrajeto

        def tempoGastoReal =  calcularTempoGastoNoTrajeto dataHoraPartida, dataHoraTransmissao

        calcularDiferencaComOPlanejado tempoGastoPlanejado, tempoGastoReal
    }

    private TimeDuration calcularDuracaoEstimadaDoTrajeto(Date dataHoraPartida, Date dataHoraChegadaPlanejada){
        dateUtil.calcularDiferenca dataHoraPartida,dataHoraChegadaPlanejada
    }

    private TimeDuration calcularTempoGastoPlanejado(Float percentualConclusao,TimeDuration duracaoEstimadaDoTrajeto){

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

    private TimeDuration calcularDiferencaComOPlanejado(TimeDuration tempoGastoPlanejado,TimeDuration tempoGastoReal){
        dateUtil.calcularDiferenca tempoGastoReal, tempoGastoPlanejado
    }
}
