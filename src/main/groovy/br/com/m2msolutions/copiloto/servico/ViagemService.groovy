package br.com.m2msolutions.copiloto.servico

import br.com.m2msolutions.copiloto.modelo.viagem.Viagem
import br.com.m2msolutions.copiloto.repositorio.ViagemExecutadaRepository
import br.com.m2msolutions.copiloto.repositorio.ViagemRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
@CacheConfig(cacheNames="viagemCopiloto")
class ViagemService {

    @Autowired
    ViagemRepository viagemRepository
    @Autowired
    ViagemExecutadaRepository viagemExecutadaRepository

    private final Logger logger = LoggerFactory.getLogger(getClass())

    @CacheEvict(key="#veiculoId")
    void removerViagemDoVeiculo(Integer veiculoId){}

    @Cacheable(unless = '#result.getEstado()<3')
    Viagem obterViagemDoVeiculo(Integer veiculoId){

        def viagem = viagemRepository.findByIdVeiculo veiculoId

        if(!viagem){
            logger.warn "Viagem do veiculo ${veiculoId} nao foi encontrada."
            return null
        }

        if(!viagem.momentoDaAbertura){
            def viagemExecutada = viagemExecutadaRepository.findOne viagem.idViagem
            viagem.momentoDaAbertura = viagemExecutada?.dataInicio
        }

        viagem
    }
}
