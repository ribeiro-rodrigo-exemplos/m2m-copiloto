package br.com.m2msolutions.copiloto.modelo.regulacao

import br.com.m2msolutions.copiloto.modelo.planejamento.RegulacaoPorPlanejamento

enum TipoRegulacao {
    PLANEJAMENTO(RegulacaoPorPlanejamento),
    DISTANCIA_MINIMA(null)

    private tipoAlgoritmo

    TipoRegulacao(Class tipoAlgoritmo){
        this.tipoAlgoritmo = tipoAlgoritmo
    }

    Class getRegulacao(){
        tipoAlgoritmo
    }
}