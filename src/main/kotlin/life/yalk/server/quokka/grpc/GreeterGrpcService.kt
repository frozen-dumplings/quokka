package life.yalk.server.quokka.grpc

import io.grpc.stub.StreamObserver
import life.yalk.grpc.GreeterGrpc
import life.yalk.grpc.HelloReply
import life.yalk.grpc.HelloRequest
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class GreeterGrpcService : GreeterGrpc.GreeterImplBase() {
    override fun sayHello(request: HelloRequest?, responseObserver: StreamObserver<HelloReply>?) {
        if (request == null || responseObserver == null) {
            return
        }
        println("Requested with :" + request.name);
        val reply = HelloReply.newBuilder().setMessage("Hi, " + request.name).build()
        responseObserver.onNext(reply)
        responseObserver.onCompleted()
    }
}
