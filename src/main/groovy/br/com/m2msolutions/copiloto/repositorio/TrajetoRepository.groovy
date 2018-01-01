package br.com.m2msolutions.copiloto.repositorio

import br.com.m2msolutions.copiloto.modelo.Linha
import br.com.m2msolutions.copiloto.modelo.Trajeto
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.BasicQuery
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.stereotype.Repository

@Repository
class TrajetoRepository{

    @Autowired
    MongoTemplate template

    Trajeto obterTrajeto(def linhaId, def trajetoId){

        linhaId = new ObjectId(linhaId as String)
        trajetoId = new ObjectId(trajetoId as String)

        Criteria match = Criteria.where("id")
                                    .is(linhaId)

        Criteria projection = Criteria.where("trajetos")
                                        .elemMatch(Criteria.where("trajetoId")
                                        .is(trajetoId))

        BasicQuery query = new BasicQuery(match.getCriteriaObject(),projection.getCriteriaObject())

        Linha linha = template.findOne query, Linha

        linha?.trajetos?.size() ? linha?.trajetos[0] : null
    }
}
