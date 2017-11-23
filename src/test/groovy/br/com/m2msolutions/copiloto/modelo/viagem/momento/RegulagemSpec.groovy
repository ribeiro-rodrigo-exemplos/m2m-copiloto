package br.com.m2msolutions.copiloto.modelo.viagem.momento

import br.com.m2msolutions.copiloto.modelo.viagem.Regulagem
import br.com.m2msolutions.copiloto.util.DateUtil
import groovy.time.TimeCategory
import groovy.time.TimeDuration
import spock.lang.Specification

/**
 * Created by rodrigo on 21/11/17.
 */
class RegulagemSpec extends Specification{

    DateUtil dateUtil

    void setup(){
        dateUtil = new DateUtil()
    }

    def 'Deve calcular prumo com atraso de 1 minuto' () {

        when: 'Criando período com atraso de 1 minuto'
            def tempoRegulado = criarPeriodo(new Date(),-1)

        then: 'Validando se a diferença do atraso com o ideal está no prumo'

            new Regulagem(tempoRegulado:tempoRegulado,dateUtil: dateUtil).prumo
    }

    def 'Deve calcular prumo com adiantamento de 1 minuto'() {

        when: 'Criando período com adiantamento de 1 minuto'
            def tempoRegulado = criarPeriodo(new Date(),1)

        then: 'Validando se a diferença do adiantamento com o ideal está no prumo'

            new Regulagem(tempoRegulado:tempoRegulado,dateUtil: dateUtil).prumo
    }

    def 'Deve calcular prumo quando veículo estiver no tempo ideal' () {

        when: 'Criando período sem adiantamento e atraso'

            def tempoRegulado = criarPeriodo(new Date(),0)

        then: 'Validando se a diferença do tempo realizado com o ideal está no prumo'

            new Regulagem(tempoRegulado: tempoRegulado,dateUtil: dateUtil).prumo
    }

    def 'Deve notificar que está fora do prumo com atraso maior de 1 minuto' () {

        when: 'Criando periodo com adiantamento de 2 minutos'

            def tempoRegulado = criarPeriodo(new Date(),2)

        then: 'Diferença entre o realizado e o ideal esta fora do prumo'

            !new Regulagem(tempoRegulado:tempoRegulado,dateUtil: dateUtil).prumo
    }

    def 'Deve notificar que esta fora do prumo com adiantamento maior de 1 minuto' () {

        when: 'Criando periodo com atraso de 2 minutos'

            def tempoRegulado = criarPeriodo new Date(), -2

        then: 'Diferença entre o realizado e o ideal está fora do prumo'

            !new Regulagem(tempoRegulado: tempoRegulado,dateUtil: dateUtil).prumo
    }

    private TimeDuration criarPeriodo(Date dataHoraInicial,Integer minutosDepois){
        use(TimeCategory){
            def dataHoraFinal = dataHoraInicial + minutosDepois.minutes
            dataHoraFinal - dataHoraInicial
        }
    }
}
