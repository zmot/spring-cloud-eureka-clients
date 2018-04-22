package com.tm.microservices.eureka.client.sentence.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tm.microservices.eureka.client.sentence.dao.NounClient;
import com.tm.microservices.eureka.client.sentence.dao.VerbClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {
    @Autowired
    private VerbClient verbClient;

    @Autowired
    private NounClient nounClient;

    @Override
    @HystrixCommand(fallbackMethod = "getDefault")
    public String getSentence() {
        return nounClient.getWord() + " " + verbClient.getWord() + ".";
    }

    public String getDefault() {
        return "This is a default sentence";
    }
}
