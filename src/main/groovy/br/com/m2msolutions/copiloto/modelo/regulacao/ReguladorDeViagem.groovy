package br.com.m2msolutions.copiloto.modelo.regulacao

import br.com.m2msolutions.copiloto.modelo.evento.RegulagemEvent
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.helpers.DateHelper
import com.google.common.eventbus.EventBus
import groovy.time.TimeDuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ReguladorDeViagem {

    @Autowired
    DateHelper dateUtil
    @Autowired
    EventBus eventBus

    Regulagem regular(MomentoViagem momentoViagem, Regulacao algoritmo){

       TimeDuration tempoDeRegulagem = algoritmo.regular momentoViagem

        def regulagem = new Regulagem(
            tempoRegulado: tempoDeRegulagem,
            dateHelper: dateUtil,
            tipoRegulacao: algoritmo.obterTipo(),
        )

        def regulagemEvent = new RegulagemEvent(
            regulagem:regulagem,
            veiculo: momentoViagem.veiculo,
            momentoDaTransmissao: momentoViagem.momentoDaTransmissao
        )

        eventBus.post regulagemEvent

        regulagem
    }
}
