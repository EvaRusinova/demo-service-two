package com.example.demo.service.two.controller;

import com.example.demo.service.two.service.DemoRestService;
import com.example.demo.service.two.service.GrpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoServiceTwoController {
    private final GrpcServiceImpl grpcServiceImpl;
    private final DemoRestService demoRestService;

    @Autowired
    public DemoServiceTwoController(GrpcServiceImpl grpcServiceImpl, DemoRestService demoRestService) {
        this.grpcServiceImpl = grpcServiceImpl;
        this.demoRestService = demoRestService;
    }

    @GetMapping("/grpc")
    public String grpcEndpoint() {
        return grpcServiceImpl.handleGrpcLogic();
    }

    @GetMapping("/rest")
    public String restEndpoint() {
        return demoRestService.handleRestLogic();
    }
}
