package br.com.m2msolutions.copiloto.helpers.hazelcast.portable

import com.hazelcast.nio.serialization.PortableReader
import com.hazelcast.nio.serialization.PortableWriter
import com.hazelcast.nio.serialization.VersionedPortable

class AlocacaoPortable implements VersionedPortable {

    String partida
    String chegada
    String horarioId
    Long dataTransmissao
    Integer idVeiculo

    @Override
    int getFactoryId() {
        return 1
    }

    @Override
    int getClassId() {
        return 1
    }

    @Override
    int getClassVersion() {
        return 1
    }

    @Override
    void writePortable(PortableWriter writer) throws IOException {
        writer.writeUTF 'horarioId',horarioId
        writer.writeUTF 'partida', partida
        writer.writeUTF 'chegada', chegada
        writer.writeLong 'dataTransmissao',dataTransmissao
        writer.writeInt 'idVeiculo', idVeiculo
    }

    @Override
    void readPortable(PortableReader reader) throws IOException {
        horarioId = reader.readUTF 'horarioId'
        partida = reader.readUTF 'partida'
        chegada = reader.readUTF 'chegada'
        dataTransmissao = reader.readLong 'dataTransmissao'
        idVeiculo = reader.readInt 'idVeiculo'
    }
}
