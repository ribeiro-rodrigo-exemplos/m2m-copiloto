package br.com.m2msolutions.copiloto.helpers

import org.springframework.stereotype.Component

@Component
class NumberHelper {

    Boolean ehNegativo(Integer numero){
        numero != Math.sqrt(numero.power(2) as Integer)
    }
}
