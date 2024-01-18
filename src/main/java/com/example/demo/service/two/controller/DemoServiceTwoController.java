package com.example.demo.service.two.controller;

import com.example.demo.service.two.service.GrpcServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoServiceTwoController {

    private final GrpcServiceImpl grpcServiceImpl;

    @GetMapping("/grpc")
    public String grpcEndpoint() {
        return grpcServiceImpl.handleGrpcLogic();
    }

    @GetMapping("/rest")
    public String restEndpoint() {
        return "Ala bala, call received";
    }
}
