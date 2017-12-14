package br.com.m2msolutions.copiloto.modelo.viagem

import br.com.m2msolutions.copiloto.led.CopilotoLed
import br.com.m2msolutions.copiloto.modelo.Regulacao
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.helpers.DateHelper
import groovy.time.TimeDuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ReguladorDeViagem {

    @Autowired
    DateHelper dateUtil
    @Autowired
    CopilotoLed copilotoLed

    Regulagem regular(MomentoViagem momentoViagem,Regulacao algoritmo){

       TimeDuration tempoDeRegulagem = algoritmo.regular momentoViagem

        def regulagem = new Regulagem(tempoRegulado: tempoDeRegulagem,dateUtil: dateUtil)

        copilotoLed.enviarComando(
            momentoViagem?.veiculo?.clienteId,
            momentoViagem?.veiculo?.veiculoId,
            momentoViagem?.veiculo?.modulo?.modelo,
            momentoViagem?.veiculo?.modulo?.identificador,
            regulagem.tempoReguladoEmMinutosESegundos()
        )

        regulagem
    }
}
