// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/copiloto.proto

package br.com.m2msolutions.copiloto.grpc;

public final class CopilotoProto {
  private CopilotoProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RegulagemRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RegulagemRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RegulagemResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RegulagemResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RegulagemResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RegulagemResult_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024proto/copiloto.proto\"\311\001\n\020RegulagemRequ" +
      "est\022\021\n\tidCliente\030\001 \001(\005\022\021\n\tidVeiculo\030\002 \001(" +
      "\005\022\017\n\007idLinha\030\003 \001(\t\022\021\n\tidTrajeto\030\004 \001(\t\022\024\n" +
      "\014modeloModulo\030\006 \001(\t\022\033\n\023identificadorModu" +
      "lo\030\007 \001(\t\022\033\n\023dataHoraTransmissao\030\010 \001(\003\022\033\n" +
      "\023percentualConclusao\030\t \001(\002\"Q\n\021RegulagemR" +
      "esponse\022 \n\006result\030\001 \001(\0132\020.RegulagemResul" +
      "t\022\032\n\022copilotoHabilitado\030\002 \001(\010\"G\n\017Regulag" +
      "emResult\022\030\n\020minutosAdiantado\030\001 \001(\005\022\032\n\022re" +
      "gulagemRealizada\030\002 \001(\0102>\n\010Copiloto\0222\n\007Re",
      "gular\022\021.RegulagemRequest\032\022.RegulagemResp" +
      "onse\"\000B4\n!br.com.m2msolutions.copiloto.g" +
      "rpcB\rCopilotoProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_RegulagemRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_RegulagemRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RegulagemRequest_descriptor,
        new java.lang.String[] { "IdCliente", "IdVeiculo", "IdLinha", "IdTrajeto", "ModeloModulo", "IdentificadorModulo", "DataHoraTransmissao", "PercentualConclusao", });
    internal_static_RegulagemResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_RegulagemResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RegulagemResponse_descriptor,
        new java.lang.String[] { "Result", "CopilotoHabilitado", });
    internal_static_RegulagemResult_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_RegulagemResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RegulagemResult_descriptor,
        new java.lang.String[] { "MinutosAdiantado", "RegulagemRealizada", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
