package br.com.m2msolutions.copiloto.modelo.planejamento

import br.com.m2msolutions.copiloto.builder.AlocacaoBuilder
import br.com.m2msolutions.copiloto.builder.TransmissaoBuilder
import br.com.m2msolutions.copiloto.modelo.dispositivo.Modulo
import br.com.m2msolutions.copiloto.modelo.viagem.Regulagem
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagemBuilder
import br.com.m2msolutions.copiloto.servico.ViagemService
import br.com.m2msolutions.copiloto.util.DateUtil
import groovy.time.TimeDuration
import spock.lang.Specification

class RegulacaoPorPlanejamentoSpec extends Specification {

    MomentoViagemBuilder momentoBuilder
    AlocacaoBuilder alocacaoBuilder
    TransmissaoBuilder transmissaoBuilder
    ViagemService viagemService

    RegulacaoPorPlanejamento regulacao
    DateUtil dateUtil

    def setup(){

        alocacaoBuilder = new AlocacaoBuilder()

        viagemService = Mock ViagemService
        momentoBuilder = new MomentoViagemBuilder(viagemService: viagemService)
        transmissaoBuilder = new TransmissaoBuilder()

        dateUtil = new DateUtil()

        regulacao = new RegulacaoPorPlanejamento(dateUtil: dateUtil)

    }

    def "Deve calcular diferença com veículo adiantado" (){

        given: "Criando alocação da viagem"

            def alocacao = alocacaoBuilder
                                .planejadaPara(new Date())
                                .comMinutosDeDuracao(60)
                                .iniciouComMinutosDeAtraso(5)
                                .criar()

        and: "Criando momento exato da transmissão"

            def momentoDaTransmissao = transmissaoBuilder
                                            .emViagemComAlocacao(alocacao)
                                            .transmitiuAposMinutosDeViagem(7)

        and: "Criando um instante da viagem"

            MomentoViagem momento = momentoBuilder
                                        .criarMomento()
                                            .naLinha("Linha12")
                                            .doCliente(209)
                                            .noTrajeto("14")
                                            .comPercentualDeConclusao(25)
                                            .comVeiculo(1212)
                                            .comModulo(new Modulo(modelo:"MAXTRACK",identificador:"0101"))
                                            .transmitiuEm(momentoDaTransmissao)
                                        .criar()

        when: "Realizando regulagem com o algoritmo de planejamento"

            def tempoRegulado = regulacao.regular momento

        then:

            (1.._) * viagemService.obterAlocacaoDoVeiculo(1212) >> alocacao
            7 == emMinutos(tempoRegulado)
    }

    def "Deve calcular diferença com veículo atrasado" (){

        given: "Criando alocação da viagem"

            def alocacao = alocacaoBuilder
                                .planejadaPara(new Date())
                                .comMinutosDeDuracao(60)
                                .iniciouComMinutosDeAtraso(20)
                                .criar()

        and: "Criando momento exato da transmissão"

            def momentoDaTransmissao = transmissaoBuilder
                                            .emViagemComAlocacao(alocacao)
                                            .transmitiuAposMinutosDeViagem(20)

        and: "Criando um instante da viagem"

            MomentoViagem momento = momentoBuilder
                                        .criarMomento()
                                            .naLinha("Linha12")
                                            .doCliente(209)
                                            .noTrajeto("TRAJETO12")
                                            .comPercentualDeConclusao(10)
                                            .comVeiculo(1212)
                                            .comModulo(new Modulo(modelo:"MAXTRACK",identificador:"0101"))
                                            .transmitiuEm(momentoDaTransmissao)
                                        .criar()

        when: "Realizando regulagem com o algoritmo de planejamento"

            def tempoRegulado = regulacao.regular momento

        then:

            (1.._) * viagemService.obterAlocacaoDoVeiculo(1212) >> alocacao
            -16 == emMinutos(tempoRegulado)

    }

    def "Deve calcular diferença com veículo no ponto ideal" () {

        given: "Criando alocação da viagem"

            def alocacao = alocacaoBuilder
                                .planejadaPara(new Date())
                                .comMinutosDeDuracao(60)
                                .iniciouComMinutosDeAtraso(10)
                                .criar()

        and: "Criando momento exato da transmissão"

            def momentoDaTransmissao = transmissaoBuilder
                                            .emViagemComAlocacao(alocacao)
                                            .transmitiuAposMinutosDeViagem(25)

        and: "Criando um instante da viagem"

            MomentoViagem momento = momentoBuilder
                                        .criarMomento()
                                        .naLinha("Linha12")
                                        .doCliente(209)
                                        .noTrajeto("TRAJETO12")
                                        .comPercentualDeConclusao(50)
                                        .comVeiculo(1212)
                                        .comModulo(new Modulo(modelo:"MAXTRACK",identificador:"0101"))
                                        .transmitiuEm(momentoDaTransmissao)
                                        .criar()

        when: "Realizando regulagem com o algoritmo de planejamento"

            def tempoRegulado = regulacao.regular momento

        then:

            (1.._) * viagemService.obterAlocacaoDoVeiculo(1212) >> alocacao
            0 == emMinutos(tempoRegulado)
    }

    def "Deve calcular prumo com adiantamento de 1 minuto" () {

        given: "Criando alocação da viagem"

            def alocacao = alocacaoBuilder
                                .planejadaPara(new Date())
                                .comMinutosDeDuracao(60)
                                .iniciouComMinutosDeAtraso(10)
                                .criar()

        and: "Criando momento exato da transmissão"

            def momentoDaTransmissao = transmissaoBuilder
                                            .emViagemComAlocacao(alocacao)
                                            .transmitiuAposMinutosDeViagem(25)

        and: "Criando um instante da viagem"

            MomentoViagem momento = momentoBuilder
                                        .criarMomento()
                                            .naLinha("Linha12")
                                            .doCliente(209)
                                            .noTrajeto("TRAJETO12")
                                            .comPercentualDeConclusao(50)
                                            .comVeiculo(1212)
                                            .comModulo(new Modulo(modelo:"MAXTRACK",identificador:"0101"))
                                            .transmitiuEm(momentoDaTransmissao)
                                        .criar()

        when: "Realizando regulagem com o algoritmo de planejamento"

            def tempoRegulado = regulacao.regular momento

        then:

            (1.._) * viagemService.obterAlocacaoDoVeiculo(1212) >> alocacao
            0 == emMinutos(tempoRegulado)
    }

    private Integer emMinutos(TimeDuration duration){
        dateUtil.obterDuracaosEmMinutos duration
    }
}
