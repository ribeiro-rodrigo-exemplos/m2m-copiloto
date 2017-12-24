package br.com.m2msolutions.copiloto.modelo.viagem.momento

import br.com.m2msolutions.copiloto.modelo.Veiculo
import br.com.m2msolutions.copiloto.modelo.dispositivo.Modulo
import br.com.m2msolutions.copiloto.servico.TrajetoService
import br.com.m2msolutions.copiloto.servico.ViagemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MomentoViagemBuilder {

    @Autowired
    ViagemService viagemService
    @Autowired
    TrajetoService trajetoService

    Builder criarMomento(){
        new Builder()
    }

    private class Builder{
        def situacaoViagem = new MomentoViagem(
                veiculo: new Veiculo(modulo: new Modulo()),
                viagemService:viagemService,
                trajetoService: trajetoService
        )

        Builder doCliente(Integer clienteId){
            situacaoViagem.veiculo.clienteId = clienteId
            this
        }

        Builder naLinha(String linhaId){
            situacaoViagem.linhaId = linhaId
            this
        }

        Builder emViagem(String viagemId){
            situacaoViagem.viagemId = viagemId
            this
        }

        Builder noTrajeto(String trajetoId){
            situacaoViagem.trajetoId = trajetoId
            this
        }

        Builder comVeiculo(Integer veiculoId){
            situacaoViagem.veiculo.veiculoId = veiculoId
            this
        }

        Builder comModulo(Modulo modulo){
            situacaoViagem.veiculo.modulo = modulo
            this
        }

        Builder transmitiuEm(Date momentoTransmissao){
            situacaoViagem.momentoDaTransmissao = momentoTransmissao
            this
        }

        Builder comPercentualDeConclusao(Float percentual){
            situacaoViagem.percentualDeConclusao = percentual
            this
        }

        MomentoViagem criar(){
            situacaoViagem
        }

    }
}


