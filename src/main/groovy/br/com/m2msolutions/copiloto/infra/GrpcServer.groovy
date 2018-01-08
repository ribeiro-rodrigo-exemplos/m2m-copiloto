package br.com.m2msolutions.copiloto.infra

import br.com.m2msolutions.copiloto.servico.DistanciaMinimaAdapterService
import br.com.m2msolutions.copiloto.servico.RegulagemService
import io.grpc.Server
import io.grpc.ServerBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class GrpcServer {

    @Autowired
    RegulagemService regulagemService
    @Autowired
    DistanciaMinimaAdapterService distanciaMinimaAdapterService
    Server server

    @Value('${grpc.port}')
    Integer port

    private final Logger logger = LoggerFactory.getLogger(getClass())

    void start(){

        logger.info "Iniciando Servidor Grpc na porta ${port}"

        server = build()
        server.start()
                .awaitTermination()
    }

    void stop(){

        logger.info "Finalizando Servidor Grpc"

        server?.shutdown()
    }

    private Server build(){
        def builder = ServerBuilder.forPort port
        builder.addService regulagemService
        builder.addService distanciaMinimaAdapterService
        builder.build()
    }
}
