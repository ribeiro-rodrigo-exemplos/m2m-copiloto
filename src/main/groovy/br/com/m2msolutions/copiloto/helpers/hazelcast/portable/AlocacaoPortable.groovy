package br.com.m2msolutions.copiloto.helpers.hazelcast.portable

import com.hazelcast.nio.serialization.Portable
import com.hazelcast.nio.serialization.PortableReader
import com.hazelcast.nio.serialization.PortableWriter

class AlocacaoPortable implements Portable {

    String partida
    String chegada
    String aberturaViagem

    @Override
    int getFactoryId() {
        return 1
    }

    @Override
    int getClassId() {
        return 1
    }

    @Override
    void writePortable(PortableWriter writer) throws IOException {
        writer.writeUTF 'partida', partida
        writer.writeUTF 'chegada', chegada
        writer.writeUTF 'aberturaViagem',aberturaViagem
    }

    @Override
    void readPortable(PortableReader reader) throws IOException {
        partida = reader.readUTF 'partida'
        chegada = reader.readUTF 'chegada'
        aberturaViagem = reader.readUTF 'aberturaViagem'
    }
}