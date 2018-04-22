package com.tm.microservices.eureka.client.sentence.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tm.microservices.eureka.client.sentence.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentenceController {

    @Autowired
    private SentenceService sentenceService;

    @GetMapping("/sentence")
    public String getSentence() {
        return sentenceService.getSentence();
    }
}
