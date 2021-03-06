// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/copiloto.proto

package br.com.m2msolutions.copiloto.grpc;

/**
 * Protobuf type {@code NotificacaoResponse}
 */
public  final class NotificacaoResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:NotificacaoResponse)
    NotificacaoResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NotificacaoResponse.newBuilder() to construct.
  private NotificacaoResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NotificacaoResponse() {
    notificacaoEnviada_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NotificacaoResponse(
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
          case 8: {

            notificacaoEnviada_ = input.readBool();
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
    return br.com.m2msolutions.copiloto.grpc.CopilotoProto.internal_static_NotificacaoResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return br.com.m2msolutions.copiloto.grpc.CopilotoProto.internal_static_NotificacaoResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            br.com.m2msolutions.copiloto.grpc.NotificacaoResponse.class, br.com.m2msolutions.copiloto.grpc.NotificacaoResponse.Builder.class);
  }

  public static final int NOTIFICACAOENVIADA_FIELD_NUMBER = 1;
  private boolean notificacaoEnviada_;
  /**
   * <code>bool notificacaoEnviada = 1;</code>
   */
  public boolean getNotificacaoEnviada() {
    return notificacaoEnviada_;
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
    if (notificacaoEnviada_ != false) {
      output.writeBool(1, notificacaoEnviada_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (notificacaoEnviada_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, notificacaoEnviada_);
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
    if (!(obj instanceof br.com.m2msolutions.copiloto.grpc.NotificacaoResponse)) {
      return super.equals(obj);
    }
    br.com.m2msolutions.copiloto.grpc.NotificacaoResponse other = (br.com.m2msolutions.copiloto.grpc.NotificacaoResponse) obj;

    boolean result = true;
    result = result && (getNotificacaoEnviada()
        == other.getNotificacaoEnviada());
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
    hash = (37 * hash) + NOTIFICACAOENVIADA_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getNotificacaoEnviada());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static br.com.m2msolutions.copiloto.grpc.NotificacaoResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.m2msolutions.copiloto.grpc.NotificacaoResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.m2msolutions.copiloto.grpc.NotificacaoResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.m2msolutions.copiloto.grpc.NotificacaoResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.m2msolutions.copiloto.grpc.NotificacaoResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.m2msolutions.copiloto.grpc.NotificacaoResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.m2msolutions.copiloto.grpc.NotificacaoResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.com.m2msolutions.copiloto.grpc.NotificacaoResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.com.m2msolutions.copiloto.grpc.NotificacaoResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static br.com.m2msolutions.copiloto.grpc.NotificacaoResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.com.m2msolutions.copiloto.grpc.NotificacaoResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.com.m2msolutions.copiloto.grpc.NotificacaoResponse parseFrom(
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
  public static Builder newBuilder(br.com.m2msolutions.copiloto.grpc.NotificacaoResponse prototype) {
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
   * Protobuf type {@code NotificacaoResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:NotificacaoResponse)
      br.com.m2msolutions.copiloto.grpc.NotificacaoResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return br.com.m2msolutions.copiloto.grpc.CopilotoProto.internal_static_NotificacaoResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return br.com.m2msolutions.copiloto.grpc.CopilotoProto.internal_static_NotificacaoResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              br.com.m2msolutions.copiloto.grpc.NotificacaoResponse.class, br.com.m2msolutions.copiloto.grpc.NotificacaoResponse.Builder.class);
    }

    // Construct using br.com.m2msolutions.copiloto.grpc.NotificacaoResponse.newBuilder()
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
      notificacaoEnviada_ = false;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return br.com.m2msolutions.copiloto.grpc.CopilotoProto.internal_static_NotificacaoResponse_descriptor;
    }

    public br.com.m2msolutions.copiloto.grpc.NotificacaoResponse getDefaultInstanceForType() {
      return br.com.m2msolutions.copiloto.grpc.NotificacaoResponse.getDefaultInstance();
    }

    public br.com.m2msolutions.copiloto.grpc.NotificacaoResponse build() {
      br.com.m2msolutions.copiloto.grpc.NotificacaoResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public br.com.m2msolutions.copiloto.grpc.NotificacaoResponse buildPartial() {
      br.com.m2msolutions.copiloto.grpc.NotificacaoResponse result = new br.com.m2msolutions.copiloto.grpc.NotificacaoResponse(this);
      result.notificacaoEnviada_ = notificacaoEnviada_;
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
      if (other instanceof br.com.m2msolutions.copiloto.grpc.NotificacaoResponse) {
        return mergeFrom((br.com.m2msolutions.copiloto.grpc.NotificacaoResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(br.com.m2msolutions.copiloto.grpc.NotificacaoResponse other) {
      if (other == br.com.m2msolutions.copiloto.grpc.NotificacaoResponse.getDefaultInstance()) return this;
      if (other.getNotificacaoEnviada() != false) {
        setNotificacaoEnviada(other.getNotificacaoEnviada());
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
      br.com.m2msolutions.copiloto.grpc.NotificacaoResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (br.com.m2msolutions.copiloto.grpc.NotificacaoResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean notificacaoEnviada_ ;
    /**
     * <code>bool notificacaoEnviada = 1;</code>
     */
    public boolean getNotificacaoEnviada() {
      return notificacaoEnviada_;
    }
    /**
     * <code>bool notificacaoEnviada = 1;</code>
     */
    public Builder setNotificacaoEnviada(boolean value) {
      
      notificacaoEnviada_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool notificacaoEnviada = 1;</code>
     */
    public Builder clearNotificacaoEnviada() {
      
      notificacaoEnviada_ = false;
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


    // @@protoc_insertion_point(builder_scope:NotificacaoResponse)
  }

  // @@protoc_insertion_point(class_scope:NotificacaoResponse)
  private static final br.com.m2msolutions.copiloto.grpc.NotificacaoResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new br.com.m2msolutions.copiloto.grpc.NotificacaoResponse();
  }

  public static br.com.m2msolutions.copiloto.grpc.NotificacaoResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NotificacaoResponse>
      PARSER = new com.google.protobuf.AbstractParser<NotificacaoResponse>() {
    public NotificacaoResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new NotificacaoResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NotificacaoResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NotificacaoResponse> getParserForType() {
    return PARSER;
  }

  public br.com.m2msolutions.copiloto.grpc.NotificacaoResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

