package com.tm.microservices.eureka.client.sentence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class SentenceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/sentence")
    public String getSentence() {
        return getWordFromService("eureka-client-noun") + " " + getWordFromService("eureka-client-verb") + ".";
    }

    private String getWordFromService(String name) {
        List<ServiceInstance> instances = discoveryClient.getInstances(name);
        ServiceInstance instance = instances.iterator().next();
        return new RestTemplate().getForObject(instance.getUri(), String.class);
    }
}
