package br.com.m2msolutions.copiloto.helpers

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@Component
class JsonHelper {

    private ObjectMapper mapper

    String serializar(def objeto){
        StringWriter writer = new StringWriter()
        mapper.writeValue writer, objeto
        writer.toString()
    }

    @PostConstruct
    void init(){
        mapper = new ObjectMapper()
    }
}
