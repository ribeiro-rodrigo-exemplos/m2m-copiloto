package br.com.m2msolutions.copiloto.modelo.viagem

import br.com.m2msolutions.copiloto.modelo.Regulacao
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.util.DateUtil
import groovy.time.TimeDuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ReguladorDeViagem {

    @Autowired
    DateUtil dateUtil

    Regulagem regular(MomentoViagem momentoViagem,Regulacao algoritmo){
       TimeDuration tempoDeRegulagem =  algoritmo.regular momentoViagem
        new Regulagem(tempoRegulado: tempoDeRegulagem,dateUtil: dateUtil)
    }
}
