package br.com.m2msolutions.copiloto.modelo.regulacao

import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.helpers.DateHelper
import br.com.m2msolutions.copiloto.repositorio.RegulagemRepository
import groovy.time.TimeDuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class ReguladorDeViagem {

    @Autowired
    DateHelper dateHelper
    @Autowired
    ApplicationEventPublisher publisher
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

        publisher.publishEvent regulagemEvent

        regulagem
    }
}
