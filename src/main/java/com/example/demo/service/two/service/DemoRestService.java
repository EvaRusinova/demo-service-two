package com.example.demo.service.two.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DemoRestService {
    private final WebClient webClient;

    @Autowired
    public DemoRestService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081").build();
    }

    public String handleRestLogic() {
        long startTime = System.currentTimeMillis();
        String restResult = performRestLogic();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for REST: " + (endTime - startTime) + "ms");

        return restResult;
    }

    private String performRestLogic() {
        return webClient.get().uri("/demo/grpc").retrieve().bodyToMono(String.class).block();
    }
}
