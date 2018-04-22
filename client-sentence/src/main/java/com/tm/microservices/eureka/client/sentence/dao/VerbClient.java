package com.tm.microservices.eureka.client.sentence.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client-verb")
public interface VerbClient {
    @GetMapping("/")
    String getWord();
}
