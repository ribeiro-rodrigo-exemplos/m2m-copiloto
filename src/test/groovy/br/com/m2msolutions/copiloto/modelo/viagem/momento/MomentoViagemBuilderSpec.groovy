package br.com.m2msolutions.copiloto.modelo.viagem.momento

import br.com.m2msolutions.copiloto.modelo.Trajeto
import br.com.m2msolutions.copiloto.modelo.dispositivo.Modulo
import br.com.m2msolutions.copiloto.modelo.viagem.Alocacao
import br.com.m2msolutions.copiloto.servico.TrajetoService
import br.com.m2msolutions.copiloto.servico.ViagemService
import spock.lang.Specification

class MomentoViagemBuilderSpec extends Specification {

    MomentoViagemBuilder builder
    ViagemService viagemService
    TrajetoService trajetoService

    void setup(){

        viagemService = Mock(ViagemService){
            obterAlocacaoDoVeiculo(_) >> new Alocacao()
        }

        trajetoService = Mock(TrajetoService){
            obterTrajeto(*_) >> new Trajeto()
        }

        builder = new MomentoViagemBuilder(viagemService: viagemService,trajetoService: trajetoService)
    }

    def "Deve criar momento da viagem" () {

        when: "criando momento da viagem"

            MomentoViagem momento = builder
                                        .criarMomento()
                                            .comVeiculo(14)
                                            .comModulo(new Modulo(modelo: "Maxtrack",identificador:"BTRE"))
                                            .comPercentualDeConclusao(25f)
                                            .noTrajeto("TRAJETO12")
                                            .comPercentualDeConclusao(25f)
                                            .naLinha("LINHA14")
                                            .doCliente(209)
                                            .transmitiuEm(new Date())
                                        .criar()

        then: "O momento deve ser criado com todos os dados configurados"

            momento.veiculo.veiculoId == 14
            momento.veiculo.modulo.modelo == "Maxtrack"
            momento.trajetoId == "TRAJETO12"
            momento.linhaId == "LINHA14"
            momento.veiculo.clienteId == 209
            momento.percentualDeConclusao == 25f
            momento.momentoDaTransmissao
            momento.trajeto
            momento.alocacao
    }
}
