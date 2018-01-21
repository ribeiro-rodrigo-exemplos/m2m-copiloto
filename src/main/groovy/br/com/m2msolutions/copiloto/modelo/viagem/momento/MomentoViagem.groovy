package br.com.m2msolutions.copiloto.modelo.viagem.momento

import br.com.m2msolutions.copiloto.modelo.Trajeto
import br.com.m2msolutions.copiloto.modelo.Veiculo
import br.com.m2msolutions.copiloto.modelo.viagem.Alocacao
import br.com.m2msolutions.copiloto.modelo.viagem.ControladorDeViagem
import br.com.m2msolutions.copiloto.modelo.viagem.Viagem
import groovy.transform.PackageScope

class MomentoViagem {

    Date momentoDaTransmissao
    BigDecimal percentualDeConclusao
    Veiculo veiculo

    private String linhaId
    private String trajetoId
    private Viagem viagem
    private Trajeto trajeto
    private ControladorDeViagem controladorDeViagem

    @PackageScope
    void setTrajetoId(String trajetoId){
        this.trajetoId = trajetoId
    }

    @PackageScope
    void setLinhaId(String linhaId){
        this.linhaId = linhaId
    }

    Alocacao getAlocacao(){
        controladorDeViagem.obterAlocacao this
    }

    Viagem getViagem(){
        if(viagem)
            return viagem

        viagem = controladorDeViagem.obterViagem this
        viagem
    }

    Trajeto getTrajeto(){
        if(trajeto)
            return trajeto

        trajeto = controladorDeViagem.obterTrajeto this
        trajeto
    }

    String getTrajetoId(){
        trajetoId
    }

    String getLinhaId(){
        linhaId
    }
}


