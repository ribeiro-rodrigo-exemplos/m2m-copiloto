package br.com.m2msolutions.copiloto.servico

import br.com.m2msolutions.copiloto.grpc.NotificacaoGrpc
import br.com.m2msolutions.copiloto.grpc.NotificacaoRequest
import br.com.m2msolutions.copiloto.grpc.NotificacaoResponse
import br.com.m2msolutions.copiloto.helpers.DateHelper
import br.com.m2msolutions.copiloto.modelo.Veiculo
import br.com.m2msolutions.copiloto.modelo.evento.RegulagemEvent
import br.com.m2msolutions.copiloto.modelo.regulacao.Regulagem
import br.com.m2msolutions.copiloto.modelo.regulacao.TipoRegulacao
import br.com.m2msolutions.copiloto.servico.notificador.WebNotificador
import groovy.time.TimeCategory
import groovy.time.TimeDuration
import io.grpc.stub.StreamObserver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DistanciaMinimaAdapterService extends NotificacaoGrpc.NotificacaoImplBase {

    @Autowired
    WebNotificador webNotificador
    @Autowired
    DateHelper dateHelper

    private final Logger logger = LoggerFactory.getLogger(getClass())

    @Override
    void notificar(NotificacaoRequest request, StreamObserver<NotificacaoResponse> responseObserver) {

        logger.info "Notificacao de regulagem recebida ${request.getIdVeiculo()}"

        def veiculo = new Veiculo(
            veiculoId: request.getIdVeiculo(),
            clienteId: request.getIdCliente(),
            distribuicao: request.getDistribuicao()
        )
        def tempoRegulado = obterDuracao(request.getTempoRegulado())

        def regulagem = new Regulagem(
                tipoRegulacao: TipoRegulacao.DISTANCIA_MINIMA,
                tempoRegulado: tempoRegulado,
                dateHelper: dateHelper
        )

        RegulagemEvent evento = new RegulagemEvent(regulagem: regulagem,veiculo: veiculo)

        webNotificador.enviarRegulagem(evento)

        def response = NotificacaoResponse
                                    .newBuilder()
                                    .setNotificacaoEnviada(true)
                                    .build()

        responseObserver.onNext response
        responseObserver.onCompleted()
    }

    private TimeDuration obterDuracao(Long minutos){
        use(TimeCategory){
            minutos.toInteger().minutes
        }
    }
}
