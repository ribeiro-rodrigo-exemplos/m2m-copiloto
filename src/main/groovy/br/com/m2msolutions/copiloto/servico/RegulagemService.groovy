package br.com.m2msolutions.copiloto.servico

import br.com.m2msolutions.copiloto.grpc.RegulacaoGrpc
import br.com.m2msolutions.copiloto.grpc.RegulagemRequest
import br.com.m2msolutions.copiloto.grpc.RegulagemResponse
import br.com.m2msolutions.copiloto.grpc.RegulagemResult
import br.com.m2msolutions.copiloto.modelo.dispositivo.Modulo
import br.com.m2msolutions.copiloto.modelo.regulacao.ReguladorDeViagem
import br.com.m2msolutions.copiloto.modelo.regulacao.Regulagem
import br.com.m2msolutions.copiloto.modelo.regulacao.RegulagemException
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagemBuilder
import br.com.m2msolutions.copiloto.helpers.DateHelper
import io.grpc.Status
import io.grpc.StatusException
import io.grpc.stub.StreamObserver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RegulagemService extends RegulacaoGrpc.RegulacaoImplBase {

    @Autowired
    MomentoViagemBuilder momentoViagemBuilder
    @Autowired
    CopilotoManager manager
    @Autowired
    ReguladorDeViagem reguladorDeViagem
    @Autowired
    DateHelper dateHelper

    private final Logger logger = LoggerFactory.getLogger(getClass())

    @Override
    void regular(RegulagemRequest request, StreamObserver<RegulagemResponse> responseObserver) {

        logger.info "Requisicao recebida: Trajeto: ${request?.idTrajeto}, Veiculo: ${request?.idVeiculo}, " +
                "Cliente: ${request?.idCliente}."

        MomentoViagem momentoViagem = criarMomentoDaViagem request

        def trajeto = momentoViagem.trajeto

        if(trajeto && trajeto.tipoRegulacao){
            def algoritmoDeRegulacao = manager.obterRegulacao trajeto.tipoRegulacao

            try{

                logger.info "Tipo de regulagem configurada para o trajeto ${trajeto.trajetoId}: ${trajeto.tipoRegulacao}"

                def regulagem = reguladorDeViagem.regular momentoViagem, algoritmoDeRegulacao
                responseObserver.onNext(criarResposta(regulagem))
            }
            catch (RegulagemException e){
                logger.warn "Não foi possivel regular a viagem ${e.message}"
                responseObserver.onNext(criarResposta(null))
            }
            catch (Exception e){
                logger.error "Erro ao regular a viagem: ${e.message}"
                responseObserver.onError(new StatusException(Status.INTERNAL))
            }
        }
        else{
            logger.warn "Trajeto ${request.idTrajeto} não encontrado ou nao possui algoritmo configurado."
            responseObserver.onNext(criarRespostaEmBranco())
        }

        responseObserver.onCompleted()

        logger.info 'Resposta enviada ao cliente.'
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
                    .transmitiuEm(dateHelper.converter(request.getDataHoraTransmissao()))
                .criar()
    }

    private RegulagemResponse criarResposta(Regulagem regulagem){

        RegulagemResult result = RegulagemResult.newBuilder()
                                            .setTempoRegulado(regulagem ? regulagem.getTempoRegulado() : new Double(0.0))
                                            .setDataHoraRegulagem(0l)
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
