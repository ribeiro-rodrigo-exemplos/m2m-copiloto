package br.com.m2msolutions.copiloto.helpers.hazelcast.portable

import com.hazelcast.nio.serialization.Portable
import com.hazelcast.nio.serialization.PortableFactory

class CopilotoPortableFactory implements PortableFactory {

    @Override
    Portable create(int classId) {

        if(classId == 1)
            return new AlocacaoPortable()

        return null
    }
}
