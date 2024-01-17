package com.example.demo.service.two.service;

import com.example.grpc.DemoRequest;
import com.example.grpc.DemoResponse;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class GrpcServiceImpl {

    public void grpc(DemoRequest request, StreamObserver<DemoResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Received Message: " + message);
        DemoResponse demoResponse = DemoResponse.newBuilder()
                .setMessage("Received your message: " + message)
                .build();

        responseObserver.onNext(demoResponse);
        responseObserver.onCompleted();
    }

    public String handleGrpcLogic() {
        long startTime = System.currentTimeMillis();
        String restResult = performGRPCLogic();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for REST: " + (endTime - startTime) + "ms");
        return restResult;
    }

    private String performGRPCLogic() {
        return "Received your message. Hello from gRPC Server.";
    }
}