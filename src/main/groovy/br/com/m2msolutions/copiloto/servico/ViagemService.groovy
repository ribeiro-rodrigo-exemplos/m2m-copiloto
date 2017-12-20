package br.com.m2msolutions.copiloto.servico

import br.com.m2msolutions.copiloto.helpers.DateHelper
import br.com.m2msolutions.copiloto.modelo.viagem.Alocacao
import br.com.m2msolutions.copiloto.repositorio.AlocacaoRepository
import br.com.m2msolutions.copiloto.repositorio.HorarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.sql.Time

@Service
class ViagemService {

    @Autowired
    HorarioRepository horarioRepository
    @Autowired
    AlocacaoRepository alocacaoRepository
    @Autowired
    DateHelper dateHelper

    Alocacao obterAlocacaoDoVeiculo(Integer veiculoId){

        def alocacao = alocacaoRepository.obterAlocacaoDoVeiculo veiculoId

        if(!alocacao)
            return null

        def horarioDaAlocacao = horarioRepository.findOne alocacao.horarioId

        if(!horarioDaAlocacao)
            return null

        alocacao.partidaPlanejada = dateHelper.criarInstanteDoDia alocacao.momentoDaPartida, horarioDaAlocacao.partida as Time
        alocacao.chegadaPlanejada = dateHelper.criarInstanteDoDia alocacao.momentoDaPartida, horarioDaAlocacao.chegada as Time

        if(horarioDaAlocacao.partida.after(horarioDaAlocacao.chegada))
            alocacao.chegadaPlanejada = alocacao.chegadaPlanejada + 1

        alocacao
    }
}
