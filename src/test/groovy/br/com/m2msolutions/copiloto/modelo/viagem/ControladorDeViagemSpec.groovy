package br.com.m2msolutions.copiloto.modelo.viagem

import br.com.m2msolutions.copiloto.modelo.Trajeto
import br.com.m2msolutions.copiloto.modelo.dispositivo.Modulo
import br.com.m2msolutions.copiloto.modelo.regulacao.RegulagemEvent
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagemBuilder
import br.com.m2msolutions.copiloto.repositorio.RegulagemRepository
import br.com.m2msolutions.copiloto.servico.TrajetoService
import br.com.m2msolutions.copiloto.servico.ViagemService
import spock.lang.Specification

class ControladorDeViagemSpec extends Specification {

    MomentoViagemBuilder momentoBuilder
    ControladorDeViagem controladorDeViagem
    ViagemService viagemService
    TrajetoService trajetoService
    RegulagemRepository regulagemRepository

    def setup(){
        viagemService = Mock ViagemService
        trajetoService = Mock TrajetoService
        regulagemRepository = Mock RegulagemRepository

        controladorDeViagem = new ControladorDeViagem(viagemService: viagemService,trajetoService: trajetoService,
                regulagemRepository: regulagemRepository)
        momentoBuilder = new MomentoViagemBuilder(controladorDeViagem: controladorDeViagem)
    }

    def 'deve retornar viagem' () {

        given: 'Criando momento da viagem'

            MomentoViagem momento = momentoBuilder
                                        .criarMomento()
                                            .naLinha('Linha12')
                                            .doCliente(209)
                                            .noTrajeto('TRAJETO12')
                                            .comPercentualDeConclusao(16)
                                            .comVeiculo(1212)
                                            .comModulo(new Modulo(modelo:'MAXTRACK',identificador:'0101'))
                                        .criar()

        and: 'Criando viagem que deve ser retornada'

            def viagem = new Viagem()

        when: 'Retornando viagem pelo controlador'

            def viagemRetornada = controladorDeViagem.obterViagem momento

        then:

            (1.._) * regulagemRepository.obterUltimaRegulagemDoVeiculo(momento.veiculo.veiculoId) >> new RegulagemEvent(percentualDeConclusao: 10.0)
            (1.._) * viagemService.obterViagemDoVeiculo(momento.veiculo.veiculoId) >> viagem

            viagemRetornada == viagem

    }

    def 'deve retornar alocacao' () {

        given: 'Criando momento da viagem'

            MomentoViagem momento = momentoBuilder
                                        .criarMomento()
                                            .naLinha('Linha12')
                                            .doCliente(209)
                                            .noTrajeto('TRAJETO12')
                                            .comPercentualDeConclusao(16)
                                            .comVeiculo(1212)
                                            .comModulo(new Modulo(modelo:'MAXTRACK',identificador:'0101'))
                                        .criar()

        and: 'Criando viagem que deve ser retornada'

            def trajeto = new Trajeto()

        when: 'Retornando viagem pelo controlador'

            def trajetoRetornado = controladorDeViagem.obterTrajeto momento

        then:

            (1.._) * trajetoService.obterTrajeto(momento.linhaId,momento.trajetoId) >> trajeto

            trajetoRetornado == trajeto

    }

    def 'deve limpar caches caso o momento atual nao seja continuacao do momento anterior' () {

        given: 'Criando momento da viagem com 10% de conclusao'

            MomentoViagem momento = momentoBuilder
                                        .criarMomento()
                                            .naLinha('Linha12')
                                            .doCliente(209)
                                            .noTrajeto('TRAJETO12')
                                            .comPercentualDeConclusao(10)
                                            .comVeiculo(1212)
                                            .comModulo(new Modulo(modelo:'MAXTRACK',identificador:'0101'))
                                        .criar()

        and: 'Criando viagem que deve ser retornada'

            def viagem = new Viagem()

        when: 'Retornando viagem pelo controlador'

            def viagemRetornada = controladorDeViagem.obterViagem momento

        then: 'Regulagem anterior tem 90% de conclusao, logo o momento atual nao pode ser continuacao do momento anterior'

            (1.._) * regulagemRepository.obterUltimaRegulagemDoVeiculo(momento.veiculo.veiculoId) >> new RegulagemEvent(percentualDeConclusao: 90.0)
             1 * viagemService.removerViagemDoVeiculo(momento.veiculo.veiculoId)
             1 * regulagemRepository.remover(momento.veiculo.veiculoId)
            (1.._) * viagemService.obterViagemDoVeiculo(momento.veiculo.veiculoId) >> viagem

        viagemRetornada == viagem

    }

    def 'nao deve limpar caches caso o momento atual seja continuacao do momento anterior' () {

        given: 'Criando momento da viagem com 14% de conclusao'

            MomentoViagem momento = momentoBuilder
                                        .criarMomento()
                                            .naLinha('Linha12')
                                            .doCliente(209)
                                            .noTrajeto('TRAJETO12')
                                            .comPercentualDeConclusao(14)
                                            .comVeiculo(1212)
                                            .comModulo(new Modulo(modelo:'MAXTRACK',identificador:'0101'))
                                        .criar()

        and: 'Criando viagem que deve ser retornada'

            def viagem = new Viagem()

        when: 'Retornando viagem pelo controlador'

            def viagemRetornada = controladorDeViagem.obterViagem momento

        then: 'Regulagem anterior tem 12% de conclusao, logo o momento atual é continuação do momento anterior'

            1 * regulagemRepository.obterUltimaRegulagemDoVeiculo(momento.veiculo.veiculoId) >> new RegulagemEvent(percentualDeConclusao: 12.0)
            0 * viagemService.removerViagemDoVeiculo(momento.veiculo.veiculoId)
            0 * regulagemRepository.remover(momento.veiculo.veiculoId)
            1 * viagemService.obterViagemDoVeiculo(momento.veiculo.veiculoId) >> viagem

        viagemRetornada == viagem

    }
}
