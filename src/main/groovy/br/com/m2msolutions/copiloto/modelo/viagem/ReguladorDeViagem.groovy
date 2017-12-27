package br.com.m2msolutions.copiloto.modelo.viagem

import br.com.m2msolutions.copiloto.helpers.NumberHelper
import br.com.m2msolutions.copiloto.led.CopilotoLed
import br.com.m2msolutions.copiloto.modelo.Regulacao
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.helpers.DateHelper
import br.com.m2msolutions.copiloto.servico.WebSocketService
import groovy.time.TimeDuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ReguladorDeViagem {

    @Autowired
    DateHelper dateUtil
    @Autowired
    NumberHelper numberHelper
    @Autowired
    CopilotoLed copilotoLed
    @Autowired
    WebSocketService webSocketService

    Regulagem regular(MomentoViagem momentoViagem,Regulacao algoritmo){

       TimeDuration tempoDeRegulagem = algoritmo.regular momentoViagem

        def regulagem = new Regulagem(tempoRegulado: tempoDeRegulagem, dateHelper: dateUtil,numberHelper:numberHelper)

        copilotoLed.enviarComando(
            momentoViagem?.veiculo?.clienteId,
            momentoViagem?.veiculo?.veiculoId,
            momentoViagem?.veiculo?.modulo?.modelo,
            momentoViagem?.veiculo?.modulo?.identificador,
            regulagem.tempoReguladoEmMinutosESegundos()
        )

        webSocketService.enviarRegulagem(momentoViagem.veiculo.veiculoId,regulagem)

        regulagem
    }
}
