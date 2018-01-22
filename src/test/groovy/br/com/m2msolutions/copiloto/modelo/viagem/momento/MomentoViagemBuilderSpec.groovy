package br.com.m2msolutions.copiloto.modelo.viagem.momento

import br.com.m2msolutions.copiloto.modelo.Trajeto
import br.com.m2msolutions.copiloto.modelo.dispositivo.Modulo
import br.com.m2msolutions.copiloto.modelo.viagem.Alocacao
import br.com.m2msolutions.copiloto.modelo.viagem.ControladorDeViagem
import br.com.m2msolutions.copiloto.modelo.viagem.Viagem
import spock.lang.Specification

class MomentoViagemBuilderSpec extends Specification {

    MomentoViagemBuilder builder
    ControladorDeViagem controladorDeViagem

    void setup(){

        controladorDeViagem = Mock(ControladorDeViagem){
            obterViagem(_) >> new Viagem(alocacao: new Alocacao())
            obterAlocacao(_) >> new Alocacao()
            obterTrajeto(_) >> new Trajeto()
        }

        builder = new MomentoViagemBuilder(controladorDeViagem: controladorDeViagem)
    }

    def 'Deve criar momento da viagem' () {

        when: 'criando momento da viagem'

            MomentoViagem momento = builder
                                        .criarMomento()
                                            .comVeiculo(14)
                                            .comModulo(new Modulo(modelo: 'Maxtrack',identificador:'BTRE'))
                                            .comPercentualDeConclusao(25f)
                                            .noTrajeto('TRAJETO12')
                                            .comPercentualDeConclusao(25f)
                                            .naLinha('LINHA14')
                                            .doCliente(209)
                                            .transmitiuEm(new Date())
                                        .criar()

        then: 'O momento deve ser criado com todos os dados configurados'

            momento.veiculo.veiculoId == 14
            momento.veiculo.modulo.modelo == 'Maxtrack'
            momento.trajetoId == 'TRAJETO12'
            momento.linhaId == 'LINHA14'
            momento.veiculo.clienteId == 209
            momento.percentualDeConclusao == 25f
            momento.momentoDaTransmissao
            momento.trajeto
            momento.alocacao
    }
}
