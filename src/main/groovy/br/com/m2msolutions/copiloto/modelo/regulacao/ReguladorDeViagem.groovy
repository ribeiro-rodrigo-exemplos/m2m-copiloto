package br.com.m2msolutions.copiloto.modelo.regulacao

import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.helpers.DateHelper
import br.com.m2msolutions.copiloto.repositorio.RegulagemRepository
import com.google.common.eventbus.EventBus
import groovy.time.TimeDuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ReguladorDeViagem {

    @Autowired
    DateHelper dateHelper
    @Autowired
    EventBus eventBus
    @Autowired
    RegulagemRepository regulagemRepository

    Regulagem regular(MomentoViagem momentoViagem, Regulacao algoritmo){

       TimeDuration tempoDeRegulagem = algoritmo.regular momentoViagem

        def regulagem = new Regulagem(
            tempoRegulado: dateHelper.obterMinutosESegundosEmNumeroReal(tempoDeRegulagem),
            tipoRegulacao: algoritmo.obterTipo(),
        )

        def regulagemEvent = new RegulagemEvent(
            regulagem:regulagem,
            veiculo: momentoViagem.veiculo,
            momentoDaTransmissao: momentoViagem.momentoDaTransmissao,
            percentualDeConclusao: momentoViagem.percentualDeConclusao
        )

        regulagemRepository.salvar regulagemEvent

        eventBus.post regulagemEvent

        regulagem
    }
}
