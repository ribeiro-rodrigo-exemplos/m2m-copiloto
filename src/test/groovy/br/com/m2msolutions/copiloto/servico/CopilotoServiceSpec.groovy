package br.com.m2msolutions.copiloto.servico

import br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoRequest
import br.com.m2msolutions.copiloto.modelo.Regulacao
import br.com.m2msolutions.copiloto.modelo.TipoRegulacao
import br.com.m2msolutions.copiloto.modelo.Trajeto
import br.com.m2msolutions.copiloto.modelo.planejamento.RegulacaoPorPlanejamento
import br.com.m2msolutions.copiloto.modelo.viagem.ReguladorDeViagem
import br.com.m2msolutions.copiloto.modelo.viagem.Regulagem
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagemBuilder
import br.com.m2msolutions.copiloto.util.DateUtil
import io.grpc.stub.StreamObserver
import spock.lang.Specification

class CopilotoServiceSpec extends Specification {

    CopilotoService copilotoService
    TrajetoService trajetoService
    CopilotoManager copilotoManager
    ReguladorDeViagem reguladorDeViagem
    Regulacao regulacao
    MomentoViagemBuilder momentoViagemBuilder

    DateUtil dateUtil

    StreamObserver streamObserver

    void setup(){

        copilotoManager = Mock CopilotoManager
        reguladorDeViagem = Mock ReguladorDeViagem
        regulacao = Mock RegulacaoPorPlanejamento

        streamObserver = Mock StreamObserver

        momentoViagemBuilder = new MomentoViagemBuilder()

        dateUtil = new DateUtil()
        copilotoService = new CopilotoService(
                manager: copilotoManager,
                momentoViagemBuilder: momentoViagemBuilder,
                dateUtil: new DateUtil(),
                reguladorDeViagem: reguladorDeViagem
        )
    }

    def 'Deve executar algoritmo de regulaçao configurado para o trajeto' () {

        given: 'Preparando objeto de requisiçao de regulaçao'

            def request = CopilotoRequest
                                .newBuilder()
                                    .setDataHoraTransmissao(agora())
                                    .setIdCliente(209)
                                    .setModeloModulo('MAXTRACK')
                                    .setIdentificadorModulo('129345')
                                    .setIdLinha('23')
                                    .setIdTrajeto('Trajeto01')
                                    .setIdVeiculo(1414)
                                    .setPercentualConclusao(25)
                                .build()

        and: 'Criando mock do trajeto service retornando trajeto configurado para planejamento'

            trajetoService = Mock(TrajetoService){
                obterTrajeto('23','Trajeto01') >> new Trajeto(tipoRegulacao: TipoRegulacao.PLANEJAMENTO)
            }

        and: 'Injetando mock do trajetoService no momentoViagemBuilder'

            momentoViagemBuilder.trajetoService = trajetoService

        and: 'Criando mock da regulagem retornada'

            def regulagem = Mock(Regulagem){
                tempoReguladoEmMinutos() >> 5
            }

        when: 'Copiloto Service recebe requisiçao de regulaçao'

            copilotoService.regular request, streamObserver

        then:

            1 * copilotoManager.obterRegulacao(TipoRegulacao.PLANEJAMENTO) >> regulacao
            1 * reguladorDeViagem.regular(_,regulacao) >> regulagem
            1 * streamObserver.onNext(_)
            1 * streamObserver.onCompleted()
    }

    def 'Não deve retornar nada caso o trajeto não exista' () {

        given: 'Preparando objeto de requisiçao de regulaçao'

            def request = CopilotoRequest
                                .newBuilder()
                                    .setDataHoraTransmissao(agora())
                                    .setIdCliente(209)
                                    .setModeloModulo('MAXTRACK')
                                    .setIdentificadorModulo('129345')
                                    .setIdLinha('23')
                                    .setIdTrajeto('Trajeto01')
                                    .setIdVeiculo(1414)
                                    .setPercentualConclusao(25)
                                .build()

        and: 'Criando mock do trajeto service retornando um trajeto nulo'

            trajetoService = Mock(TrajetoService){
                obterTrajeto('23','Trajeto01') >> null
            }

        and: 'Injetando mock do trajetoService no momentoViagemBuilder'

            momentoViagemBuilder.trajetoService = trajetoService

        when: 'Copiloto Service recebe requisiçao de regulaçao'

            copilotoService.regular request, streamObserver

        then:

            1 * streamObserver.onCompleted()

    }

    def 'Não deve retornar nada caso o trajeto não possua nenhum algoritmo de regulação configurado' () {

        given: 'Preparando objeto de requisiçao de regulaçao'

            def request = CopilotoRequest
                                .newBuilder()
                                    .setDataHoraTransmissao(agora())
                                    .setIdCliente(209)
                                    .setModeloModulo('MAXTRACK')
                                    .setIdentificadorModulo('129345')
                                    .setIdLinha('23')
                                    .setIdTrajeto('Trajeto01')
                                    .setIdVeiculo(1414)
                                    .setPercentualConclusao(25)
                                .build()

        and: 'Criando mock do trajeto service retornando um trajeto sem algoritmo configurado'

            trajetoService = Mock(TrajetoService){
                obterTrajeto('23','Trajeto01') >> new Trajeto()
            }

        and: 'Injetando mock do trajetoService no momentoViagemBuilder'

            momentoViagemBuilder.trajetoService = trajetoService

        when: 'Copiloto Service recebe requisiçao de regulaçao'

            copilotoService.regular request, streamObserver

        then:

            1 * streamObserver.onCompleted()
    }

    private long agora(){
        System.currentTimeMillis()
    }

}
