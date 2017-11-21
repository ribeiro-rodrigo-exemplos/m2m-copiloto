package br.com.m2msolutions.copiloto.modelo.planejamento

import br.com.m2msolutions.copiloto.builder.AlocacaoBuilder
import br.com.m2msolutions.copiloto.modelo.dispositivo.Modulo
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagemBuilder
import br.com.m2msolutions.copiloto.servico.ViagemService
import spock.lang.Specification

class RegulacaoPorPlanejamentoSpec extends Specification {

    MomentoViagemBuilder momentoBuilder
    AlocacaoBuilder alocacaoBuilder
    ViagemService viagemService


    def setup(){

        alocacaoBuilder = new AlocacaoBuilder()

        viagemService = Mock ViagemService
        momentoBuilder = new MomentoViagemBuilder(viagemService: viagemService)
    }

    def "Deve calcular diferença com veículo adiantado" (){

        given: "Criando alocação da viagem"

            def alocacao = alocacaoBuilder
                                .planejadaPara(new Date())
                                .comMinutosDeDuracao(60)
                                .iniciouComMinutosDeAtraso(5)
                                .criar()


        and: "Criando um instante da viagem"

            MomentoViagem momento = momentoBuilder
                                        .criarMomento()
                                            .naLinha("Linha12")
                                            .doCliente(209)
                                            .noTrajeto("14")
                                            .comPercentualDeConclusao(25)
                                            .comVeiculo(1212)
                                            .comModulo(new Modulo(modelo:"MAXTRACK",identificador:"0101"))
                                            .transmitiuEm()
                                        .criar()

    }

    def "Deve calcular diferença com veículo atrasado" (){

    }

    def "Deve calcular diferença com veículo no ponto ideal" () {

    }

    def "Deve calcular prumo com adiantamento de 1 minuto" () {

    }

    def "Deve calcular prumo com atraso de 1 minuto" () {

    }

    def "Deve informar que veículo está fora do prumo quando estiver atrasado" () {

    }

    def "Deve informar que veículo está fora do prumo quando estiver adiantado" () {

    }


}
