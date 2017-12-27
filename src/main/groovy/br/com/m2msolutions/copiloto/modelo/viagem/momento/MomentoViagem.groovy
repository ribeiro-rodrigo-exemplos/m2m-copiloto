package br.com.m2msolutions.copiloto.modelo.viagem.momento

import br.com.m2msolutions.copiloto.modelo.Trajeto
import br.com.m2msolutions.copiloto.modelo.Veiculo
import br.com.m2msolutions.copiloto.modelo.viagem.Alocacao
import br.com.m2msolutions.copiloto.modelo.viagem.Viagem
import br.com.m2msolutions.copiloto.servico.TrajetoService
import br.com.m2msolutions.copiloto.servico.ViagemService
import groovy.transform.PackageScope

class MomentoViagem {

    Date momentoDaTransmissao
    BigDecimal percentualDeConclusao
    Veiculo veiculo

    private Viagem viagem
    private String linhaId
    private String trajetoId
    private ViagemService viagemService
    private TrajetoService trajetoService

    @PackageScope
    void setTrajetoId(String trajetoId){
        this.trajetoId = trajetoId
    }

    @PackageScope
    void setLinhaId(String linhaId){
        this.linhaId = linhaId
    }

    @PackageScope
    void setViagemService(ViagemService viagemService){
        this.viagemService = viagemService
    }

    @PackageScope
    void setTrajetoService(TrajetoService trajetoService){
        this.trajetoService = trajetoService
    }

    Alocacao getAlocacao(){
        getViagem()?.alocacao
    }

    Viagem getViagem(){
        if(!viagem)
            viagem = viagemService.obterViagemDoVeiculo veiculo.veiculoId

        viagem
    }

    Trajeto getTrajeto(){
        trajetoService.obterTrajeto linhaId, trajetoId
    }
}


