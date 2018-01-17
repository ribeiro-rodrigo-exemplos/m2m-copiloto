package br.com.m2msolutions.copiloto.modelo

import br.com.m2msolutions.copiloto.modelo.dispositivo.Modulo

class Veiculo implements Serializable {
    Modulo modulo
    Integer clienteId
    Integer veiculoId
    Integer distribuicao
}
