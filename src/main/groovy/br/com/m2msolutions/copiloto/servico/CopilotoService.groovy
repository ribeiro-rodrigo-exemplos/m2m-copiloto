package br.com.m2msolutions.copiloto.servico

import br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoGrpc
import br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoRequest
import br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoResponse
import br.com.m2msolutions.copiloto.modelo.dispositivo.Modulo
import br.com.m2msolutions.copiloto.modelo.viagem.ReguladorDeViagem
import br.com.m2msolutions.copiloto.modelo.viagem.Regulagem
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagemBuilder
import br.com.m2msolutions.copiloto.util.DateUtil
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
    DateUtil dateUtil

    @Override
    void regular(CopilotoRequest request, StreamObserver<CopilotoResponse> responseObserver) {

        MomentoViagem momentoViagem = criarMomentoDaViagem request

        def trajeto = momentoViagem.trajeto

        if(trajeto && trajeto.tipoRegulacao){
            def algoritmoDeRegulacao = manager.obterRegulacao trajeto.tipoRegulacao
            def regulagem = reguladorDeViagem.regular momentoViagem, algoritmoDeRegulacao
            responseObserver.onNext(criarResposta(regulagem))
        }

        responseObserver.onCompleted()
    }

    private MomentoViagem criarMomentoDaViagem(CopilotoRequest request){
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

    private CopilotoResponse criarResposta(Regulagem regulagem){
        CopilotoResponse
                .newBuilder()
                .setMinutosAdiantado(regulagem?.tempoReguladoEmMinutos())
                .build()
    }
}
