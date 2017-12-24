package br.com.m2msolutions.copiloto.modelo.viagem.momento

import br.com.m2msolutions.copiloto.modelo.Trajeto
import br.com.m2msolutions.copiloto.modelo.Veiculo
import br.com.m2msolutions.copiloto.modelo.viagem.Alocacao
import br.com.m2msolutions.copiloto.servico.TrajetoService
import br.com.m2msolutions.copiloto.servico.ViagemService
import groovy.transform.PackageScope

class MomentoViagem {

    Date momentoDaTransmissao
    BigDecimal percentualDeConclusao
    Veiculo veiculo

    private Alocacao alocacao
    private String linhaId
    private String viagemId
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
    void setViagemId(String viagemId){
        this.viagemId = viagemId
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
        if(!alocacao)
            alocacao = viagemService.obterAlocacaoDaViagem viagemId

        alocacao
    }

    Trajeto getTrajeto(){
        trajetoService.obterTrajeto linhaId, trajetoId
    }
}


