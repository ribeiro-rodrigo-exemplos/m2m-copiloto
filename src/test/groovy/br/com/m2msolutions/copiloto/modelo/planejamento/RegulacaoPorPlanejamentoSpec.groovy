package br.com.m2msolutions.copiloto.modelo.planejamento

import br.com.m2msolutions.copiloto.builder.ViagemBuilder
import br.com.m2msolutions.copiloto.builder.TransmissaoBuilder
import br.com.m2msolutions.copiloto.helpers.NumberHelper
import br.com.m2msolutions.copiloto.modelo.dispositivo.Modulo
import br.com.m2msolutions.copiloto.modelo.regulacao.RegulagemException
import br.com.m2msolutions.copiloto.modelo.viagem.ControladorDeViagem
import br.com.m2msolutions.copiloto.modelo.viagem.Viagem
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagemBuilder
import br.com.m2msolutions.copiloto.helpers.DateHelper
import groovy.time.TimeDuration
import spock.lang.Specification

class RegulacaoPorPlanejamentoSpec extends Specification {

    MomentoViagemBuilder momentoBuilder
    ViagemBuilder viagemBuilder
    TransmissaoBuilder transmissaoBuilder
    ControladorDeViagem controladorDeViagem

    RegulacaoPorPlanejamento regulacao
    DateHelper dateUtil

    def setup(){

        viagemBuilder = new ViagemBuilder()

        controladorDeViagem = Mock ControladorDeViagem
        momentoBuilder = new MomentoViagemBuilder(controladorDeViagem: controladorDeViagem)
        transmissaoBuilder = new TransmissaoBuilder()

        dateUtil = new DateHelper(numberHelper: new NumberHelper())

        regulacao = new RegulacaoPorPlanejamento(dateUtil: dateUtil)

    }

    def 'Deve calcular diferença com veículo adiantado' (){

        given: 'Criando alocação da viagem'

            def viagem = viagemBuilder
                                .planejadaPara(new Date())
                                .comMinutosDeDuracao(60)
                                .iniciouComMinutosDeAtraso(5)
                                .criar()

        and: 'Criando momento exato da transmissão'

            def momentoDaTransmissao = transmissaoBuilder
                                            .emViagem(viagem)
                                            .transmitiuAposTempoDeViagem(7)

        and: 'Criando um instante da viagem'

            MomentoViagem momento = momentoBuilder
                                        .criarMomento()
                                            .naLinha('Linha12')
                                            .doCliente(209)
                                            .noTrajeto('14')
                                            .comPercentualDeConclusao(25)
                                            .comVeiculo(1212)
                                            .comModulo(new Modulo(modelo:'MAXTRACK',identificador:'0101'))
                                            .transmitiuEm(momentoDaTransmissao)
                                        .criar()

        when: 'Realizando regulagem com o algoritmo de planejamento'

            def tempoRegulado = regulacao.regular momento

        then:

            (1.._) * controladorDeViagem.obterViagem(momento) >> viagem
            6.45 == emMinutosESegundos(tempoRegulado)
    }

    def 'Deve calcular diferença com veículo atrasado' (){

        given: 'Criando alocação da viagem'

            def viagem = viagemBuilder
                                .planejadaPara(new Date())
                                .comMinutosDeDuracao(60)
                                .iniciouComMinutosDeAtraso(21)
                                .criar()

        and: 'Criando momento exato da transmissão'

            def momentoDaTransmissao = transmissaoBuilder
                                            .emViagem(viagem)
                                            .transmitiuAposTempoDeViagem(14)

        and: 'Criando um instante da viagem'

            MomentoViagem momento = momentoBuilder
                                        .criarMomento()
                                            .naLinha('Linha12')
                                            .doCliente(209)
                                            .noTrajeto('TRAJETO12')
                                            .comPercentualDeConclusao(16)
                                            .comVeiculo(1212)
                                            .comModulo(new Modulo(modelo:'MAXTRACK',identificador:'0101'))
                                            .transmitiuEm(momentoDaTransmissao)
                                        .criar()

        when: 'Realizando regulagem com o algoritmo de planejamento'

            def tempoRegulado = regulacao.regular momento

        then:

            (1.._) * controladorDeViagem.obterViagem(momento) >> viagem
            -8.14 == emMinutosESegundos(tempoRegulado)
    }

    def 'Deve calcular diferença com veículo no ponto ideal' () {

        given: 'Criando alocação da viagem'

            def viagem = viagemBuilder
                                .planejadaPara(new Date())
                                .comMinutosDeDuracao(60)
                                .iniciouComMinutosDeAtraso(10)
                                .criar()

        and: 'Criando momento exato da transmissão'

            def momentoDaTransmissao = transmissaoBuilder
                                            .emViagem(viagem)
                                            .transmitiuAposTempoDeViagem(25)

        and: 'Criando um instante da viagem'

            MomentoViagem momento = momentoBuilder
                                        .criarMomento()
                                        .naLinha('Linha12')
                                        .doCliente(209)
                                        .noTrajeto('TRAJETO12')
                                        .comPercentualDeConclusao(50)
                                        .comVeiculo(1212)
                                        .comModulo(new Modulo(modelo:'MAXTRACK',identificador:'0101'))
                                        .transmitiuEm(momentoDaTransmissao)
                                        .criar()

        when: 'Realizando regulagem com o algoritmo de planejamento'

            def tempoRegulado = regulacao.regular momento

        then:

            (1.._) * controladorDeViagem.obterViagem(momento) >> viagem
            0.0 == emMinutosESegundos(tempoRegulado)
    }

    def 'Deve calcular prumo com adiantamento de 1 minuto' () {

        given: 'Criando alocação da viagem'

            def viagem = viagemBuilder
                                .planejadaPara(new Date())
                                .comMinutosDeDuracao(60)
                                .iniciouComMinutosDeAtraso(10)
                                .criar()

        and: 'Criando momento exato da transmissão'

            def momentoDaTransmissao = transmissaoBuilder
                                            .emViagem(viagem)
                                            .transmitiuAposTempoDeViagem(25)

        and: 'Criando um instante da viagem'

            MomentoViagem momento = momentoBuilder
                                        .criarMomento()
                                            .naLinha('Linha12')
                                            .doCliente(209)
                                            .noTrajeto('TRAJETO12')
                                            .comPercentualDeConclusao(52)
                                            .comVeiculo(1212)
                                            .comModulo(new Modulo(modelo:'MAXTRACK',identificador:'0101'))
                                            .transmitiuEm(momentoDaTransmissao)
                                        .criar()

        when: 'Realizando regulagem com o algoritmo de planejamento'

            def tempoRegulado = regulacao.regular momento

        then:

            (1.._) * controladorDeViagem.obterViagem(momento) >> viagem
            1.0 == emMinutosESegundos(tempoRegulado)
    }

    def 'Deve calcular prumo com atraso de 1 minuto' (){

        given: 'Criando alocação da viagem'

            def viagem = viagemBuilder
                                .planejadaPara(new Date())
                                .comMinutosDeDuracao(60)
                                .iniciouComMinutosDeAtraso(10)
                                .criar()

        and: 'Criando momento exato da transmissão'

            def momentoDaTransmissao = transmissaoBuilder
                                            .emViagem(viagem)
                                            .transmitiuAposTempoDeViagem(26)

        and: 'Criando um instante da viagem'

            MomentoViagem momento = momentoBuilder
                                        .criarMomento()
                                        .naLinha('Linha12')
                                        .doCliente(209)
                                        .noTrajeto('TRAJETO12')
                                        .comPercentualDeConclusao(50)
                                        .comVeiculo(1212)
                                        .comModulo(new Modulo(modelo:'MAXTRACK',identificador:'0101'))
                                        .transmitiuEm(momentoDaTransmissao)
                                        .criar()

        when: 'Realizando regulagem com o algoritmo de planejamento'

            def tempoRegulado = regulacao.regular momento

        then:

            (1.._) * controladorDeViagem.obterViagem(momento) >> viagem
            -1.0 == emMinutosESegundos(tempoRegulado)

    }

    def "Não deve realizar regulagem sem alocação de viagem" (){

        given: 'Criando alocação da viagem'

            def viagem = viagemBuilder
                                .iniciouEm(new Date())
                                .criar()

        and: 'Criando momento exato da transmissão'

            def momentoDaTransmissao = transmissaoBuilder
                    .emViagem(viagem)
                    .transmitiuAposTempoDeViagem(25)

        and: 'Criando um instante da viagem'

            MomentoViagem momento = momentoBuilder
                                        .criarMomento()
                                        .naLinha('Linha12')
                                        .doCliente(209)
                                        .noTrajeto('TRAJETO12')
                                        .comPercentualDeConclusao(50)
                                        .comVeiculo(1212)
                                        .comModulo(new Modulo(modelo:'MAXTRACK',identificador:'0101'))
                                        .transmitiuEm(momentoDaTransmissao)
                                        .criar()

        when: 'Realizando regulagem com o algoritmo de planejamento'

            regulacao.regular momento

        then:

            (1.._) * controladorDeViagem.obterViagem(momento) >> new Viagem()
            thrown(RegulagemException)
    }

    private Double emMinutosESegundos(TimeDuration duration){
        dateUtil.obterMinutosESegundosEmNumeroReal duration
    }
}
