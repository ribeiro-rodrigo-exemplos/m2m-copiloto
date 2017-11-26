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
}
