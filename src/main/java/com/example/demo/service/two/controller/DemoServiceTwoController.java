package com.example.demo.service.two.controller;

import com.example.demo.service.two.service.RestServiceSimulator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoServiceTwoController {

    private final RestServiceSimulator restServiceSimulator;

    @GetMapping("/rest")
    public void restEndpoint() {
        restServiceSimulator.simulateActivity();
    }
}
