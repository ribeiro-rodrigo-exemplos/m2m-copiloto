// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/copiloto.proto

package br.com.m2msolutions.copiloto.grpc;

/**
 * Protobuf type {@code RegulagemResult}
 */
public  final class RegulagemResult extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:RegulagemResult)
    RegulagemResultOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RegulagemResult.newBuilder() to construct.
  private RegulagemResult(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RegulagemResult() {
    tempoRegulado_ = 0D;
    dataHoraRegulagem_ = 0L;
    regulagemRealizada_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RegulagemResult(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 9: {

            tempoRegulado_ = input.readDouble();
            break;
          }
          case 16: {

            dataHoraRegulagem_ = input.readInt64();
            break;
          }
          case 24: {

            regulagemRealizada_ = input.readBool();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return br.com.m2msolutions.copiloto.grpc.CopilotoProto.internal_static_RegulagemResult_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return br.com.m2msolutions.copiloto.grpc.CopilotoProto.internal_static_RegulagemResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            br.com.m2msolutions.copiloto.grpc.RegulagemResult.class, br.com.m2msolutions.copiloto.grpc.RegulagemResult.Builder.class);
  }

  public static final int TEMPOREGULADO_FIELD_NUMBER = 1;
  private double tempoRegulado_;
  /**
   * <code>double tempoRegulado = 1;</code>
   */
  public double getTempoRegulado() {
    return tempoRegulado_;
  }

  public static final int DATAHORAREGULAGEM_FIELD_NUMBER = 2;
  private long dataHoraRegulagem_;
  /**
   * <code>int64 dataHoraRegulagem = 2;</code>
   */
  public long getDataHoraRegulagem() {
    return dataHoraRegulagem_;
  }

  public static final int REGULAGEMREALIZADA_FIELD_NUMBER = 3;
  private boolean regulagemRealizada_;
  /**
   * <code>bool regulagemRealizada = 3;</code>
   */
  public boolean getRegulagemRealizada() {
    return regulagemRealizada_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (tempoRegulado_ != 0D) {
      output.writeDouble(1, tempoRegulado_);
    }
    if (dataHoraRegulagem_ != 0L) {
      output.writeInt64(2, dataHoraRegulagem_);
    }
    if (regulagemRealizada_ != false) {
      output.writeBool(3, regulagemRealizada_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (tempoRegulado_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(1, tempoRegulado_);
    }
    if (dataHoraRegulagem_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, dataHoraRegulagem_);
    }
    if (regulagemRealizada_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, regulagemRealizada_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof br.com.m2msolutions.copiloto.grpc.RegulagemResult)) {
      return super.equals(obj);
    }
    br.com.m2msolutions.copiloto.grpc.RegulagemResult other = (br.com.m2msolutions.copiloto.grpc.RegulagemResult) obj;

    boolean result = true;
    result = result && (
        java.lang.Double.doubleToLongBits(getTempoRegulado())
        == java.lang.Double.doubleToLongBits(
            other.getTempoRegulado()));
    result = result && (getDataHoraRegulagem()
        == other.getDataHoraRegulagem());
    result = result && (getRegulagemRealizada()
        == other.getRegulagemRealizada());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TEMPOREGULADO_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getTempoRegulado()));
    hash = (37 * hash) + DATAHORAREGULAGEM_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getDataHoraRegulagem());
    hash = (37 * hash) + REGULAGEMREALIZADA_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getRegulagemRealizada());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static br.com.m2msolutions.copiloto.grpc.RegulagemResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.m2msolutions.copiloto.grpc.RegulagemResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.m2msolutions.copiloto.grpc.RegulagemResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.m2msolutions.copiloto.grpc.RegulagemResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.m2msolutions.copiloto.grpc.RegulagemResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.m2msolutions.copiloto.grpc.RegulagemResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.m2msolutions.copiloto.grpc.RegulagemResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.com.m2msolutions.copiloto.grpc.RegulagemResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.com.m2msolutions.copiloto.grpc.RegulagemResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static br.com.m2msolutions.copiloto.grpc.RegulagemResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.com.m2msolutions.copiloto.grpc.RegulagemResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.com.m2msolutions.copiloto.grpc.RegulagemResult parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(br.com.m2msolutions.copiloto.grpc.RegulagemResult prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code RegulagemResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:RegulagemResult)
      br.com.m2msolutions.copiloto.grpc.RegulagemResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return br.com.m2msolutions.copiloto.grpc.CopilotoProto.internal_static_RegulagemResult_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return br.com.m2msolutions.copiloto.grpc.CopilotoProto.internal_static_RegulagemResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              br.com.m2msolutions.copiloto.grpc.RegulagemResult.class, br.com.m2msolutions.copiloto.grpc.RegulagemResult.Builder.class);
    }

    // Construct using br.com.m2msolutions.copiloto.grpc.RegulagemResult.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      tempoRegulado_ = 0D;

      dataHoraRegulagem_ = 0L;

      regulagemRealizada_ = false;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return br.com.m2msolutions.copiloto.grpc.CopilotoProto.internal_static_RegulagemResult_descriptor;
    }

    public br.com.m2msolutions.copiloto.grpc.RegulagemResult getDefaultInstanceForType() {
      return br.com.m2msolutions.copiloto.grpc.RegulagemResult.getDefaultInstance();
    }

    public br.com.m2msolutions.copiloto.grpc.RegulagemResult build() {
      br.com.m2msolutions.copiloto.grpc.RegulagemResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public br.com.m2msolutions.copiloto.grpc.RegulagemResult buildPartial() {
      br.com.m2msolutions.copiloto.grpc.RegulagemResult result = new br.com.m2msolutions.copiloto.grpc.RegulagemResult(this);
      result.tempoRegulado_ = tempoRegulado_;
      result.dataHoraRegulagem_ = dataHoraRegulagem_;
      result.regulagemRealizada_ = regulagemRealizada_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof br.com.m2msolutions.copiloto.grpc.RegulagemResult) {
        return mergeFrom((br.com.m2msolutions.copiloto.grpc.RegulagemResult)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(br.com.m2msolutions.copiloto.grpc.RegulagemResult other) {
      if (other == br.com.m2msolutions.copiloto.grpc.RegulagemResult.getDefaultInstance()) return this;
      if (other.getTempoRegulado() != 0D) {
        setTempoRegulado(other.getTempoRegulado());
      }
      if (other.getDataHoraRegulagem() != 0L) {
        setDataHoraRegulagem(other.getDataHoraRegulagem());
      }
      if (other.getRegulagemRealizada() != false) {
        setRegulagemRealizada(other.getRegulagemRealizada());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      br.com.m2msolutions.copiloto.grpc.RegulagemResult parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (br.com.m2msolutions.copiloto.grpc.RegulagemResult) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private double tempoRegulado_ ;
    /**
     * <code>double tempoRegulado = 1;</code>
     */
    public double getTempoRegulado() {
      return tempoRegulado_;
    }
    /**
     * <code>double tempoRegulado = 1;</code>
     */
    public Builder setTempoRegulado(double value) {
      
      tempoRegulado_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double tempoRegulado = 1;</code>
     */
    public Builder clearTempoRegulado() {
      
      tempoRegulado_ = 0D;
      onChanged();
      return this;
    }

    private long dataHoraRegulagem_ ;
    /**
     * <code>int64 dataHoraRegulagem = 2;</code>
     */
    public long getDataHoraRegulagem() {
      return dataHoraRegulagem_;
    }
    /**
     * <code>int64 dataHoraRegulagem = 2;</code>
     */
    public Builder setDataHoraRegulagem(long value) {
      
      dataHoraRegulagem_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 dataHoraRegulagem = 2;</code>
     */
    public Builder clearDataHoraRegulagem() {
      
      dataHoraRegulagem_ = 0L;
      onChanged();
      return this;
    }

    private boolean regulagemRealizada_ ;
    /**
     * <code>bool regulagemRealizada = 3;</code>
     */
    public boolean getRegulagemRealizada() {
      return regulagemRealizada_;
    }
    /**
     * <code>bool regulagemRealizada = 3;</code>
     */
    public Builder setRegulagemRealizada(boolean value) {
      
      regulagemRealizada_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool regulagemRealizada = 3;</code>
     */
    public Builder clearRegulagemRealizada() {
      
      regulagemRealizada_ = false;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:RegulagemResult)
  }

  // @@protoc_insertion_point(class_scope:RegulagemResult)
  private static final br.com.m2msolutions.copiloto.grpc.RegulagemResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new br.com.m2msolutions.copiloto.grpc.RegulagemResult();
  }

  public static br.com.m2msolutions.copiloto.grpc.RegulagemResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RegulagemResult>
      PARSER = new com.google.protobuf.AbstractParser<RegulagemResult>() {
    public RegulagemResult parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new RegulagemResult(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RegulagemResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RegulagemResult> getParserForType() {
    return PARSER;
  }

  public br.com.m2msolutions.copiloto.grpc.RegulagemResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

