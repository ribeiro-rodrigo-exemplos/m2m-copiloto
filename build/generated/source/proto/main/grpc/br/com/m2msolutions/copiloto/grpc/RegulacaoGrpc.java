package br.com.m2msolutions.copiloto.grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.7.0)",
    comments = "Source: proto/copiloto.proto")
public final class RegulacaoGrpc {

  private RegulacaoGrpc() {}

  public static final String SERVICE_NAME = "Regulacao";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<br.com.m2msolutions.copiloto.grpc.RegulagemRequest,
      br.com.m2msolutions.copiloto.grpc.RegulagemResponse> METHOD_REGULAR =
      io.grpc.MethodDescriptor.<br.com.m2msolutions.copiloto.grpc.RegulagemRequest, br.com.m2msolutions.copiloto.grpc.RegulagemResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Regulacao", "Regular"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              br.com.m2msolutions.copiloto.grpc.RegulagemRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              br.com.m2msolutions.copiloto.grpc.RegulagemResponse.getDefaultInstance()))
          .setSchemaDescriptor(new RegulacaoMethodDescriptorSupplier("Regular"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegulacaoStub newStub(io.grpc.Channel channel) {
    return new RegulacaoStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegulacaoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RegulacaoBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegulacaoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RegulacaoFutureStub(channel);
  }

  /**
   */
  public static abstract class RegulacaoImplBase implements io.grpc.BindableService {

    /**
     */
    public void regular(br.com.m2msolutions.copiloto.grpc.RegulagemRequest request,
        io.grpc.stub.StreamObserver<br.com.m2msolutions.copiloto.grpc.RegulagemResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REGULAR, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_REGULAR,
            asyncUnaryCall(
              new MethodHandlers<
                br.com.m2msolutions.copiloto.grpc.RegulagemRequest,
                br.com.m2msolutions.copiloto.grpc.RegulagemResponse>(
                  this, METHODID_REGULAR)))
          .build();
    }
  }

  /**
   */
  public static final class RegulacaoStub extends io.grpc.stub.AbstractStub<RegulacaoStub> {
    private RegulacaoStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegulacaoStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegulacaoStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegulacaoStub(channel, callOptions);
    }

    /**
     */
    public void regular(br.com.m2msolutions.copiloto.grpc.RegulagemRequest request,
        io.grpc.stub.StreamObserver<br.com.m2msolutions.copiloto.grpc.RegulagemResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REGULAR, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RegulacaoBlockingStub extends io.grpc.stub.AbstractStub<RegulacaoBlockingStub> {
    private RegulacaoBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegulacaoBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegulacaoBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegulacaoBlockingStub(channel, callOptions);
    }

    /**
     */
    public br.com.m2msolutions.copiloto.grpc.RegulagemResponse regular(br.com.m2msolutions.copiloto.grpc.RegulagemRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REGULAR, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RegulacaoFutureStub extends io.grpc.stub.AbstractStub<RegulacaoFutureStub> {
    private RegulacaoFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegulacaoFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegulacaoFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegulacaoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.m2msolutions.copiloto.grpc.RegulagemResponse> regular(
        br.com.m2msolutions.copiloto.grpc.RegulagemRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REGULAR, getCallOptions()), request);
    }
  }

  private static final int METHODID_REGULAR = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegulacaoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegulacaoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGULAR:
          serviceImpl.regular((br.com.m2msolutions.copiloto.grpc.RegulagemRequest) request,
              (io.grpc.stub.StreamObserver<br.com.m2msolutions.copiloto.grpc.RegulagemResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RegulacaoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegulacaoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.com.m2msolutions.copiloto.grpc.CopilotoProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Regulacao");
    }
  }

  private static final class RegulacaoFileDescriptorSupplier
      extends RegulacaoBaseDescriptorSupplier {
    RegulacaoFileDescriptorSupplier() {}
  }

  private static final class RegulacaoMethodDescriptorSupplier
      extends RegulacaoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegulacaoMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RegulacaoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegulacaoFileDescriptorSupplier())
              .addMethod(METHOD_REGULAR)
              .build();
        }
      }
    }
    return result;
  }
}
