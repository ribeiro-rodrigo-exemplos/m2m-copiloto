package br.com.m2msolutions.copiloto.modelo.planejamento

import br.com.m2msolutions.copiloto.modelo.regulacao.Regulacao
import br.com.m2msolutions.copiloto.modelo.regulacao.TipoRegulacao
import br.com.m2msolutions.copiloto.modelo.regulacao.RegulagemException
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.helpers.DateHelper
import groovy.time.TimeCategory
import groovy.time.TimeDuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class RegulacaoPorPlanejamento implements Regulacao {

    @Autowired
    private DateHelper dateUtil
    @Value('${planejamento.minutos-de-tolerancia}')
    private Integer minutosDeTolerancia
    private final static BigDecimal PERCENTUAL_DE_CONCLUSAO_DE_VIAGEM = 100.0

    @Override
    TimeDuration regular(MomentoViagem momentoViagem) {

        if(!momentoViagem.alocacao)
            throw new RegulagemException('Não é possível regular por planejamento sem alocação')

        if(noInicioDaViagem(momentoViagem) || noFimDaViagem(momentoViagem))
            return noPrumo()

        def momentoDaAbertura = momentoViagem.viagem.momentoDaAbertura
        def momentoPlanejadoDaChegada = momentoViagem.alocacao.chegadaPlanejada
        def percentualConclusao = momentoViagem.percentualDeConclusao
        def momentoDaTransmissao = momentoViagem.momentoDaTransmissao

        def duracaoEstimadaDoTrajeto = calcularDuracaoEstimadaDoTrajeto momentoDaAbertura, momentoPlanejadoDaChegada

        def tempoGastoIdeal = calcularTempoGastoIdeal percentualConclusao, duracaoEstimadaDoTrajeto

        def tempoGasto =  calcularTempoGastoNoTrajeto momentoDaAbertura, momentoDaTransmissao

        dateUtil.calcularDiferenca tempoGasto, tempoGastoIdeal
    }

    @Override
    TipoRegulacao obterTipo() {
        return TipoRegulacao.PLANEJAMENTO
    }

    private TimeDuration noPrumo(){
        use(TimeCategory){
            0.minutes
        }
    }

    private Boolean noFimDaViagem(MomentoViagem momento){
        momento.percentualDeConclusao >= PERCENTUAL_DE_CONCLUSAO_DE_VIAGEM
    }

    private Boolean noInicioDaViagem(MomentoViagem momento){
        def tempoGasto = calcularTempoGastoNoTrajeto momento.viagem.momentoDaAbertura, momento.momentoDaTransmissao
        tempoGasto.minutes < minutosDeTolerancia
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
