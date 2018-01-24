package br.com.m2msolutions.copiloto.modelo.viagem

import br.com.m2msolutions.copiloto.modelo.Trajeto
import br.com.m2msolutions.copiloto.modelo.viagem.momento.MomentoViagem
import br.com.m2msolutions.copiloto.repositorio.RegulagemRepository
import br.com.m2msolutions.copiloto.servico.TrajetoService
import br.com.m2msolutions.copiloto.servico.ViagemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ControladorDeViagem {

    @Autowired
    private ViagemService viagemService
    @Autowired
    private RegulagemRepository regulagemRepository
    @Autowired
    private TrajetoService trajetoService

    Viagem obterViagem(MomentoViagem momentoViagem){

        if(naoEhContinuacaoDoMomentoAnterior(momentoViagem)){
            viagemService.removerViagemDoVeiculo momentoViagem?.veiculo?.veiculoId
            regulagemRepository.remover momentoViagem?.veiculo?.veiculoId
        }

        viagemService.obterViagemDoVeiculo momentoViagem?.veiculo?.veiculoId
    }

    Trajeto obterTrajeto(MomentoViagem momentoViagem){
        trajetoService.obterTrajeto momentoViagem.linhaId, momentoViagem.trajetoId
    }

    private Boolean naoEhContinuacaoDoMomentoAnterior(MomentoViagem momentoViagem){
        def ultimaRegulagem = regulagemRepository.obterUltimaRegulagemDoVeiculo momentoViagem?.veiculo?.veiculoId
        ultimaRegulagem?.percentualDeConclusao > momentoViagem?.percentualDeConclusao
    }
}
