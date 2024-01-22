package com.example.demo.service.two.service;

import com.example.grpc.DemoRequest;
import com.example.grpc.DemoResponse;
import com.example.grpc.GrpcServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class GrpcServiceImpl extends GrpcServiceGrpc.GrpcServiceImplBase {

    public void greeting(DemoRequest request, StreamObserver<DemoResponse> responseObserver) {
        String message = request.getMessage();
        log.info("Received Message: " + message);
        DemoResponse demoResponse = DemoResponse.newBuilder()
                .setMessage("Connected to gRPC...")
                .build();

        responseObserver.onNext(demoResponse);
        responseObserver.onCompleted();
    }

}