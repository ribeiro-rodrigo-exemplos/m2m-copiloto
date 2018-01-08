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
public final class NotificacaoGrpc {

  private NotificacaoGrpc() {}

  public static final String SERVICE_NAME = "Notificacao";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<br.com.m2msolutions.copiloto.grpc.NotificacaoRequest,
      br.com.m2msolutions.copiloto.grpc.NotificacaoResponse> METHOD_NOTIFICAR =
      io.grpc.MethodDescriptor.<br.com.m2msolutions.copiloto.grpc.NotificacaoRequest, br.com.m2msolutions.copiloto.grpc.NotificacaoResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Notificacao", "Notificar"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              br.com.m2msolutions.copiloto.grpc.NotificacaoRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              br.com.m2msolutions.copiloto.grpc.NotificacaoResponse.getDefaultInstance()))
          .setSchemaDescriptor(new NotificacaoMethodDescriptorSupplier("Notificar"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NotificacaoStub newStub(io.grpc.Channel channel) {
    return new NotificacaoStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NotificacaoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new NotificacaoBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NotificacaoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new NotificacaoFutureStub(channel);
  }

  /**
   */
  public static abstract class NotificacaoImplBase implements io.grpc.BindableService {

    /**
     */
    public void notificar(br.com.m2msolutions.copiloto.grpc.NotificacaoRequest request,
        io.grpc.stub.StreamObserver<br.com.m2msolutions.copiloto.grpc.NotificacaoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_NOTIFICAR, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_NOTIFICAR,
            asyncUnaryCall(
              new MethodHandlers<
                br.com.m2msolutions.copiloto.grpc.NotificacaoRequest,
                br.com.m2msolutions.copiloto.grpc.NotificacaoResponse>(
                  this, METHODID_NOTIFICAR)))
          .build();
    }
  }

  /**
   */
  public static final class NotificacaoStub extends io.grpc.stub.AbstractStub<NotificacaoStub> {
    private NotificacaoStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NotificacaoStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificacaoStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NotificacaoStub(channel, callOptions);
    }

    /**
     */
    public void notificar(br.com.m2msolutions.copiloto.grpc.NotificacaoRequest request,
        io.grpc.stub.StreamObserver<br.com.m2msolutions.copiloto.grpc.NotificacaoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_NOTIFICAR, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class NotificacaoBlockingStub extends io.grpc.stub.AbstractStub<NotificacaoBlockingStub> {
    private NotificacaoBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NotificacaoBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificacaoBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NotificacaoBlockingStub(channel, callOptions);
    }

    /**
     */
    public br.com.m2msolutions.copiloto.grpc.NotificacaoResponse notificar(br.com.m2msolutions.copiloto.grpc.NotificacaoRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_NOTIFICAR, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class NotificacaoFutureStub extends io.grpc.stub.AbstractStub<NotificacaoFutureStub> {
    private NotificacaoFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NotificacaoFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificacaoFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NotificacaoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.m2msolutions.copiloto.grpc.NotificacaoResponse> notificar(
        br.com.m2msolutions.copiloto.grpc.NotificacaoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_NOTIFICAR, getCallOptions()), request);
    }
  }

  private static final int METHODID_NOTIFICAR = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NotificacaoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NotificacaoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NOTIFICAR:
          serviceImpl.notificar((br.com.m2msolutions.copiloto.grpc.NotificacaoRequest) request,
              (io.grpc.stub.StreamObserver<br.com.m2msolutions.copiloto.grpc.NotificacaoResponse>) responseObserver);
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

  private static abstract class NotificacaoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NotificacaoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.com.m2msolutions.copiloto.grpc.CopilotoProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Notificacao");
    }
  }

  private static final class NotificacaoFileDescriptorSupplier
      extends NotificacaoBaseDescriptorSupplier {
    NotificacaoFileDescriptorSupplier() {}
  }

  private static final class NotificacaoMethodDescriptorSupplier
      extends NotificacaoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NotificacaoMethodDescriptorSupplier(String methodName) {
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
      synchronized (NotificacaoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NotificacaoFileDescriptorSupplier())
              .addMethod(METHOD_NOTIFICAR)
              .build();
        }
      }
    }
    return result;
  }
}
