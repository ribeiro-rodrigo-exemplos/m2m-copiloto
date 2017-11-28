package br.com.m2msolutions.copiloto.servico

import br.com.m2msolutions.copiloto.grpc.CopilotoGrpc
import br.com.m2msolutions.copiloto.grpc.RegulagemRequest
import br.com.m2msolutions.copiloto.grpc.RegulagemResponse
import br.com.m2msolutions.copiloto.grpc.RegulagemResult
import br.com.m2msolutions.copiloto.modelo.dispositivo.Modulo
import br.com.m2msolutions.copiloto.modelo.viagem.ReguladorDeViagem
import br.com.m2msolutions.copiloto.modelo.viagem.Regulagem
import br.com.m2msolutions.copiloto.modelo.viagem.RegulagemException
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagemBuilder
import br.com.m2msolutions.copiloto.helpers.DateHelper
import io.grpc.stub.StreamObserver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CopilotoService extends CopilotoGrpc.CopilotoImplBase {

    @Autowired
    MomentoViagemBuilder momentoViagemBuilder
    @Autowired
    CopilotoManager manager
    @Autowired
    ReguladorDeViagem reguladorDeViagem
    @Autowired
    DateHelper dateUtil

    @Override
    void regular(RegulagemRequest request, StreamObserver<RegulagemResponse> responseObserver) {

        MomentoViagem momentoViagem = criarMomentoDaViagem request

        def trajeto = momentoViagem.trajeto

        if(trajeto && trajeto.tipoRegulacao){
            def algoritmoDeRegulacao = manager.obterRegulacao trajeto.tipoRegulacao

            try{

                def regulagem = reguladorDeViagem.regular momentoViagem, algoritmoDeRegulacao
                responseObserver.onNext(criarResposta(regulagem))

            }catch (RegulagemException e){
                responseObserver.onNext(criarResposta(null))
            }
        }
        else
            responseObserver.onNext(criarRespostaEmBranco())

        responseObserver.onCompleted()
    }

    private MomentoViagem criarMomentoDaViagem(RegulagemRequest request){
        momentoViagemBuilder
                .criarMomento()
                    .naLinha(request.getIdLinha())
                    .doCliente(request.getIdCliente())
                    .noTrajeto(request.getIdTrajeto())
                    .comPercentualDeConclusao(request.getPercentualConclusao())
                    .comVeiculo(request.getIdVeiculo())
                    .comModulo(new Modulo(modelo: request.getModeloModulo(),identificador: request.getIdentificadorModulo()))
                    .transmitiuEm(dateUtil.converter(request.getDataHoraTransmissao()))
                .criar()
    }

    private RegulagemResponse criarResposta(Regulagem regulagem){

        RegulagemResult result = RegulagemResult.newBuilder()
                                                .setMinutosAdiantado(regulagem ? regulagem.tempoReguladoEmMinutos() : 0)
                                                .setRegulagemRealizada(regulagem != null)
                                                .build()
        RegulagemResponse
                .newBuilder()
                .setResult(result)
                .setCopilotoHabilitado(true)
                .build()
    }

    private RegulagemResponse criarRespostaEmBranco(){
        RegulagemResponse
                .newBuilder()
                .build()
    }
}
