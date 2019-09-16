package com.test.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: helloword.proto")
public final class ControllGrpc {

  private ControllGrpc() {}

  public static final String SERVICE_NAME = "helloworld.Controll";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @Deprecated // Use {@link #getAddMethod()} instead.
  public static final io.grpc.MethodDescriptor<HelloRequest,
      HelloReply> METHOD_ADD = getAddMethodHelper();

  private static volatile io.grpc.MethodDescriptor<HelloRequest,
      HelloReply> getAddMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<HelloRequest,
      HelloReply> getAddMethod() {
    return getAddMethodHelper();
  }

  private static io.grpc.MethodDescriptor<HelloRequest,
      HelloReply> getAddMethodHelper() {
    io.grpc.MethodDescriptor<HelloRequest, HelloReply> getAddMethod;
    if ((getAddMethod = ControllGrpc.getAddMethod) == null) {
      synchronized (ControllGrpc.class) {
        if ((getAddMethod = ControllGrpc.getAddMethod) == null) {
          ControllGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<HelloRequest, HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.Controll", "Add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloReply.getDefaultInstance()))
                  .setSchemaDescriptor(new ControllMethodDescriptorSupplier("Add"))
                  .build();
          }
        }
     }
     return getAddMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ControllStub newStub(io.grpc.Channel channel) {
    return new ControllStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ControllBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ControllBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ControllFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ControllFutureStub(channel);
  }

  /**
   */
  public static abstract class ControllImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void add(HelloRequest request,
        io.grpc.stub.StreamObserver<HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAddMethodHelper(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                HelloRequest,
                HelloReply>(
                  this, METHODID_ADD)))
          .build();
    }
  }

  /**
   */
  public static final class ControllStub extends io.grpc.stub.AbstractStub<ControllStub> {
    private ControllStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ControllStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ControllStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ControllStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void add(HelloRequest request,
        io.grpc.stub.StreamObserver<HelloReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ControllBlockingStub extends io.grpc.stub.AbstractStub<ControllBlockingStub> {
    private ControllBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ControllBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ControllBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ControllBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public HelloReply add(HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ControllFutureStub extends io.grpc.stub.AbstractStub<ControllFutureStub> {
    private ControllFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ControllFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ControllFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ControllFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<HelloReply> add(
        HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ControllImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ControllImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD:
          serviceImpl.add((HelloRequest) request,
              (io.grpc.stub.StreamObserver<HelloReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ControllBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ControllBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return HelloWorldProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Controll");
    }
  }

  private static final class ControllFileDescriptorSupplier
      extends ControllBaseDescriptorSupplier {
    ControllFileDescriptorSupplier() {}
  }

  private static final class ControllMethodDescriptorSupplier
      extends ControllBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ControllMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ControllGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ControllFileDescriptorSupplier())
              .addMethod(getAddMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
