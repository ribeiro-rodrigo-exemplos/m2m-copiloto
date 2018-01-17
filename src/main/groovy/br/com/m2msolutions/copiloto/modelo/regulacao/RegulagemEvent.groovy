package br.com.m2msolutions.copiloto.modelo.regulacao

import br.com.m2msolutions.copiloto.modelo.Veiculo
import br.com.m2msolutions.copiloto.modelo.regulacao.Regulagem
import com.fasterxml.jackson.annotation.JsonFormat

class RegulagemEvent implements Serializable {

    Regulagem regulagem
    Veiculo veiculo
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = 'yyyy-MM-dd HH:mm:ss')
    Date momentoDaRegulagem = new Date()
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = 'yyyy-MM-dd HH:mm:ss')
    Date momentoDaTransmissao
    Double percentualDeConclusao
}
