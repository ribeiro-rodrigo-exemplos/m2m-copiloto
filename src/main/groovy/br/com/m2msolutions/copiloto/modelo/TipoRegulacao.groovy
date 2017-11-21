package br.com.m2msolutions.copiloto.modelo

import br.com.m2msolutions.copiloto.modelo.planejamento.RegulacaoPorPlanejamento

enum TipoRegulacao {
    PLANEJAMENTO(RegulacaoPorPlanejamento)

    private tipoAlgoritmo

    TipoRegulacao(Class tipoAlgoritmo){
        this.tipoAlgoritmo = tipoAlgoritmo
    }

    Class getRegulacao(){
        tipoAlgoritmo
    }
}