package br.com.m2msolutions.copiloto.servico

import br.com.m2msolutions.copiloto.modelo.Regulacao
import br.com.m2msolutions.copiloto.modelo.TipoRegulacao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

@Service
class CopilotoManager {

    @Autowired
    private ApplicationContext context

    Regulacao obterRegulacao(TipoRegulacao tipo){
        try {
            context.getBean(tipo.regulacao) as Regulacao
        }
        catch (e){
            throw new RuntimeException("Algoritmo de regulação não encontrado")
        }
    }
}
