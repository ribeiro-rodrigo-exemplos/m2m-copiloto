package br.com.m2msolutions.copiloto.helpers.hazelcast.portable

import com.hazelcast.nio.serialization.PortableReader
import com.hazelcast.nio.serialization.PortableWriter
import com.hazelcast.nio.serialization.VersionedPortable

class AlocacaoPortable implements VersionedPortable {

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
        writer.writeLong 'dataTransmissao',dataTransmissao
        writer.writeInt 'idVeiculo', idVeiculo
    }

    @Override
    void readPortable(PortableReader reader) throws IOException {
        horarioId = reader.readUTF 'horarioId'
        dataTransmissao = reader.readLong 'dataTransmissao'
        idVeiculo = reader.readInt 'idVeiculo'
    }
}
