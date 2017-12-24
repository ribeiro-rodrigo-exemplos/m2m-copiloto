package br.com.m2msolutions.copiloto.helpers

import groovy.time.TimeCategory
import groovy.time.TimeDuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import java.sql.Time
import java.util.concurrent.TimeUnit

import static java.util.Calendar.*

@Component
class DateHelper {

    @Autowired
    NumberHelper numberHelper

    Date criarInstanteDoDia(Date dia, Time tempo){

        def data = dia.clone() as Date

        data[HOUR_OF_DAY] = tempo[HOUR_OF_DAY]
        data[MINUTE] = tempo[MINUTE]
        data[SECOND] = tempo[SECOND]

        data
    }

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
            def diferenca = periodoFinal - periodoInicial
            if(numberHelper.ehNegativo(diferenca.seconds) && numberHelper.ehPositivo(diferenca.minutes)){
                if(diferenca.minutes > 0){
                    diferenca = diferenca - 1.minutes
                    diferenca = diferenca + 60.seconds
                }
            }

            diferenca as TimeDuration
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
        "${duracao.minutes}.${duracao.seconds}" as Double
    }

}
