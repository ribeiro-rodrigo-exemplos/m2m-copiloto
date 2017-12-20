package br.com.m2msolutions.copiloto.servico

import br.com.m2msolutions.copiloto.builder.AlocacaoBuilder
import br.com.m2msolutions.copiloto.helpers.DateHelper
import br.com.m2msolutions.copiloto.modelo.planejamento.Horario
import br.com.m2msolutions.copiloto.modelo.viagem.Alocacao
import br.com.m2msolutions.copiloto.repositorio.AlocacaoRepository
import br.com.m2msolutions.copiloto.repositorio.HorarioRepository
import spock.lang.Specification

import java.sql.Time
import static java.util.Calendar.*

class ViagemServiceSpec extends Specification {

    AlocacaoRepository alocacaoRepository
    HorarioRepository horarioRepository
    ViagemService viagemService

    AlocacaoBuilder alocacaoBuilder

    def setup(){

        horarioRepository = Mock HorarioRepository
        alocacaoRepository = Mock AlocacaoRepository

        alocacaoBuilder = new AlocacaoBuilder()

        viagemService = new ViagemService(
                horarioRepository: horarioRepository,
                alocacaoRepository: alocacaoRepository,
                dateHelper: new DateHelper()
        )
    }

    def 'Deve retornar alocacao' () {

        given: 'Criando alocação que será retornada pelo AlocacaoRepository'

            def alocacaoRetornada = alocacaoBuilder
                                            .iniciouEm(criarData (14, 12, 2017, 14))
                                            .comHorarioId(12)
                                            .criar()

        when: 'Obtendo alocação do veículo'

            def alocacao = viagemService.obterAlocacaoDoVeiculo 14

        then:
            alocacaoRepository.obterAlocacaoDoVeiculo(14) >> alocacaoRetornada
            horarioRepository.findOne(12) >> new Horario(
                    partida: new Time(criarData (1, 1, 1970, 14).time),
                    chegada: new Time(criarData (1, 1, 1970, 16).time)
            )
            alocacao != null
    }

    def 'Deve retornar nulo caso alocacao não exista' () {

        when: 'Obtendo alocação do veículo'
            def alocacao = viagemService.obterAlocacaoDoVeiculo 14
        then:
            alocacaoRepository.obterAlocacaoDoVeiculo(_) >> null
            horarioRepository.findOne(_) >> new Horario()
            alocacao == null
    }

    def 'Nao deve retornar alocacao sem horario' () {

        when: 'Obtendo alocação do veículo'
            def alocacao = viagemService.obterAlocacaoDoVeiculo 14
        then:
            alocacaoRepository.obterAlocacaoDoVeiculo(14) >> new Alocacao(horarioId: 12)
            horarioRepository.findOne(12) >> null
            alocacao == null
    }

    def 'Deve retornar alocacao com horarios do dia da abertura de viagem' () {

        given: 'Criando alocação que será retornada pelo AlocacaoRepository'

            def alocacaoRetornada = alocacaoBuilder
                                            .iniciouEm(criarData (14, 12, 2017, 14))
                                            .comHorarioId(12)
                                            .criar()

        when: 'Obtendo alocação do veículo'

            def alocacao = viagemService.obterAlocacaoDoVeiculo 14

        then:

            alocacaoRepository.obterAlocacaoDoVeiculo(14) >> alocacaoRetornada
            horarioRepository.findOne(12) >> new Horario(
                    partida: new Time(criarData (1, 1, 1970, 14).time),
                    chegada: new Time(criarData (1, 1, 1970, 15).time)
            )

            alocacao?.partidaPlanejada[DAY_OF_MONTH] == alocacaoRetornada.momentoDaPartida[DAY_OF_MONTH]
            alocacao?.partidaPlanejada[MONTH] == alocacaoRetornada.momentoDaPartida[MONTH]
            alocacao?.partidaPlanejada[YEAR] == alocacaoRetornada.momentoDaPartida[YEAR]

            alocacao?.chegadaPlanejada[DAY_OF_MONTH] == alocacaoRetornada.momentoDaPartida[DAY_OF_MONTH]
            alocacao?.chegadaPlanejada[MONTH] == alocacaoRetornada.momentoDaPartida[MONTH]
            alocacao?.chegadaPlanejada[YEAR] == alocacaoRetornada.momentoDaPartida[YEAR]
    }

    def 'Deve retornar alocacao com horario de chegada do dia seguinte' () {

        given: 'Criando alocação que será retornada pelo AlocacaoRepository'

            def alocacaoRetornada = alocacaoBuilder
                                            .iniciouEm(criarData (14, 12, 2017, 14))
                                            .comHorarioId(12)
                                            .criar()

        when: 'Obtendo alocação do veículo'

            def alocacao = viagemService.obterAlocacaoDoVeiculo 14

        then:

            alocacaoRepository.obterAlocacaoDoVeiculo(14) >> alocacaoRetornada
            horarioRepository.findOne(12) >> new Horario(
                    partida: new Time(criarData (1, 1, 1970, 14).time),
                    chegada: new Time(criarData (1, 1, 1970, 12).time)
            )

            alocacao?.partidaPlanejada[DAY_OF_MONTH] == alocacaoRetornada.momentoDaPartida[DAY_OF_MONTH]
            alocacao?.chegadaPlanejada[DAY_OF_MONTH] == (alocacaoRetornada.momentoDaPartida + 1)[DAY_OF_MONTH]
    }

    private Date criarData(Integer dia, Integer mes, Integer ano, Integer hora, Integer minuto = 0){

        def calendar = Calendar.instance

        calendar.set YEAR, ano
        calendar.set MONTH, mes - 1
        calendar.set DAY_OF_MONTH , dia
        calendar.set HOUR_OF_DAY, hora
        calendar.set MINUTE, minuto
        calendar.time
    }
}
