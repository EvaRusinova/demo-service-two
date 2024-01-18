package com.example.demo.service.two.service;

import com.example.grpc.DemoRequest;
import com.example.grpc.DemoResponse;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class GrpcServiceImpl {

    // TODO: refactoring here needed. We need to somehow call grpc method
    public void grpc(DemoRequest request, StreamObserver<DemoResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Received Message: " + message);
        DemoResponse demoResponse = DemoResponse.newBuilder()
                .setMessage("Received your message: " + message)
                .build();

        responseObserver.onNext(demoResponse);
//        responseObserver.onCompleted();
    }

    public String handleGrpcLogic() {
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for REST: " + (endTime - startTime) + "ms");
        return null;
    }

}