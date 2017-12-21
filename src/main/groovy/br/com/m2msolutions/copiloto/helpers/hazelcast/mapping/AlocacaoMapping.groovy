package br.com.m2msolutions.copiloto.helpers.hazelcast.mapping

import br.com.m2msolutions.copiloto.helpers.hazelcast.portable.AlocacaoPortable
import br.com.m2msolutions.copiloto.modelo.viagem.Alocacao
import br.com.m2msolutions.copiloto.helpers.DateHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class AlocacaoMapping {

    @Autowired
    DateHelper dateUtil

    Alocacao map(AlocacaoPortable portable){
        new Alocacao(
                momentoDaPartida: dateUtil.converter(portable.dataTransmissao),
                horarioId: portable.horarioId as Integer
        )
    }
}
