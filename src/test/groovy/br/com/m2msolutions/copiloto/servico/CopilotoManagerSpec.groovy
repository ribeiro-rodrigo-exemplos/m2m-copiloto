package br.com.m2msolutions.copiloto.servico

import br.com.m2msolutions.copiloto.modelo.TipoRegulacao
import br.com.m2msolutions.copiloto.modelo.planejamento.RegulacaoPorPlanejamento
import org.springframework.context.ApplicationContext
import spock.lang.Specification

class CopilotoManagerSpec extends Specification {

    private CopilotoManager manager
    private ApplicationContext context

    def setup(){
        context = Mock ApplicationContext
        manager = new CopilotoManager(context: context)
    }

    def "Deve resolver regulação por planejamento" (){

        when: "Solicitando ao Copiloto Manager o tipo de regulação requisitado"

            def algoritmo = manager.obterRegulacao TipoRegulacao.PLANEJAMENTO

        then:

            1 * context.getBean(RegulacaoPorPlanejamento) >> new RegulacaoPorPlanejamento()
            algoritmo.class in RegulacaoPorPlanejamento
    }

    def "Deve disparar exceção se não encontrar a regulação" (){

        when: "Solicitando ao Copiloto Manager um tipo de regulação inexistente"

            manager.obterRegulacao TipoRegulacao.PLANEJAMENTO

        then:

            context.getBean(TipoRegulacao.PLANEJAMENTO.regulacao) >> {throw new RuntimeException()}
            thrown(RuntimeException)
    }
}
