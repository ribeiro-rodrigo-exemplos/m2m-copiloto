package br.com.m2msolutions.copiloto.helpers

import groovy.time.TimeCategory
import groovy.time.TimeDuration
import org.springframework.stereotype.Component

import java.util.concurrent.TimeUnit

@Component
class DateHelper {

    Date converter(Long timeMillis){
        new Date(timeMillis)
    }

    Date converter(String dataStr){
        new Date().parse("yyyy-MM-dd hh:mm:ss",dataStr)
    }

    TimeDuration calcularDiferenca(Date dataInicial, Date dataFinal){
        use(TimeCategory){
            dataFinal - dataInicial
        }
    }

    TimeDuration calcularDiferenca(TimeDuration periodoInicial,TimeDuration periodoFinal){
        use(TimeCategory){
            periodoFinal - periodoInicial
        }
    }

    Integer obterDuracaosEmMinutos(TimeDuration duracao){
        TimeUnit.MILLISECONDS.toMinutes(duracao.toMilliseconds())
    }

    TimeDuration obterDuracao(BigDecimal tempo){

        def segundos = (tempo.minus(tempo.toInteger())).multiply(10)

        segundos = segundos.multiply(60).div(10)

        use(TimeCategory){
            def resto = segundos.toInteger().div(60).toInteger()
            segundos -= resto.multiply 60
            tempo.toInteger().minutes + resto.minutes + segundos.toInteger().seconds

        } as TimeDuration
    }

    Double obterMinutosESegundosEmNumeroReal(TimeDuration duracao){

        def segundos = 0
        Integer minutos = duracao.minutes

        if(duracao.seconds){

            segundos = duracao.seconds.div 100

            if(ehNegativo(minutos))
                segundos = -segundos
        }

        duracao.minutes + segundos
    }

    private Boolean ehNegativo(Integer numero){
        numero != Math.sqrt(numero.power(2) as Integer)
    }
}
