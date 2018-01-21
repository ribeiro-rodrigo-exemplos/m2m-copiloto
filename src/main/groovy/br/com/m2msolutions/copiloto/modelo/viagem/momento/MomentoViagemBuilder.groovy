package br.com.m2msolutions.copiloto.modelo.viagem.momento

import br.com.m2msolutions.copiloto.modelo.Veiculo
import br.com.m2msolutions.copiloto.modelo.dispositivo.Modulo
import br.com.m2msolutions.copiloto.modelo.viagem.ControladorDeViagem
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MomentoViagemBuilder {

    @Autowired
    ControladorDeViagem controladorDeViagem

    Builder criarMomento(){
        new Builder()
    }

    private class Builder{
        def momentoViagem = new MomentoViagem(
                veiculo: new Veiculo(modulo: new Modulo()),
                controladorDeViagem: controladorDeViagem
        )

        Builder doCliente(Integer clienteId){
            momentoViagem.veiculo.clienteId = clienteId
            this
        }

        Builder naLinha(String linhaId){
            momentoViagem.linhaId = linhaId
            this
        }

        Builder noTrajeto(String trajetoId){
            momentoViagem.trajetoId = trajetoId
            this
        }

        Builder comVeiculo(Integer veiculoId){
            momentoViagem.veiculo.veiculoId = veiculoId
            this
        }

        Builder comModulo(Modulo modulo){
            momentoViagem.veiculo.modulo = modulo
            this
        }

        Builder transmitiuEm(Date momentoTransmissao){
            momentoViagem.momentoDaTransmissao = momentoTransmissao
            this
        }

        Builder comPercentualDeConclusao(Float percentual){
            momentoViagem.percentualDeConclusao = percentual
            this
        }

        MomentoViagem criar(){
            momentoViagem
        }

    }
}


