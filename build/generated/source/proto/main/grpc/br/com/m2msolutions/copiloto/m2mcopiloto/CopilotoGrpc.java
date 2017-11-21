package br.com.m2msolutions.copiloto.m2mcopiloto;

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
public final class CopilotoGrpc {

  private CopilotoGrpc() {}

  public static final String SERVICE_NAME = "Copiloto";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoRequest,
      br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoResponse> METHOD_REGULAR =
      io.grpc.MethodDescriptor.<br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoRequest, br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Copiloto", "Regular"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoResponse.getDefaultInstance()))
          .setSchemaDescriptor(new CopilotoMethodDescriptorSupplier("Regular"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CopilotoStub newStub(io.grpc.Channel channel) {
    return new CopilotoStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CopilotoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CopilotoBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CopilotoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CopilotoFutureStub(channel);
  }

  /**
   */
  public static abstract class CopilotoImplBase implements io.grpc.BindableService {

    /**
     */
    public void regular(br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoRequest request,
        io.grpc.stub.StreamObserver<br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REGULAR, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_REGULAR,
            asyncUnaryCall(
              new MethodHandlers<
                br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoRequest,
                br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoResponse>(
                  this, METHODID_REGULAR)))
          .build();
    }
  }

  /**
   */
  public static final class CopilotoStub extends io.grpc.stub.AbstractStub<CopilotoStub> {
    private CopilotoStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CopilotoStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CopilotoStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CopilotoStub(channel, callOptions);
    }

    /**
     */
    public void regular(br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoRequest request,
        io.grpc.stub.StreamObserver<br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REGULAR, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CopilotoBlockingStub extends io.grpc.stub.AbstractStub<CopilotoBlockingStub> {
    private CopilotoBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CopilotoBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CopilotoBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CopilotoBlockingStub(channel, callOptions);
    }

    /**
     */
    public br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoResponse regular(br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REGULAR, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CopilotoFutureStub extends io.grpc.stub.AbstractStub<CopilotoFutureStub> {
    private CopilotoFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CopilotoFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CopilotoFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CopilotoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoResponse> regular(
        br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoRequest request) {
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
    private final CopilotoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CopilotoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGULAR:
          serviceImpl.regular((br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoRequest) request,
              (io.grpc.stub.StreamObserver<br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoResponse>) responseObserver);
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

  private static abstract class CopilotoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CopilotoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.com.m2msolutions.copiloto.m2mcopiloto.CopilotoProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Copiloto");
    }
  }

  private static final class CopilotoFileDescriptorSupplier
      extends CopilotoBaseDescriptorSupplier {
    CopilotoFileDescriptorSupplier() {}
  }

  private static final class CopilotoMethodDescriptorSupplier
      extends CopilotoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CopilotoMethodDescriptorSupplier(String methodName) {
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
      synchronized (CopilotoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CopilotoFileDescriptorSupplier())
              .addMethod(METHOD_REGULAR)
              .build();
        }
      }
    }
    return result;
  }
}
