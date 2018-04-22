package com.tm.microservices.eureka.client.sentence;

import com.tm.microservices.eureka.client.sentence.dao.NounClient;
import com.tm.microservices.eureka.client.sentence.dao.VerbClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentenceController {

    @Autowired
    private VerbClient verbClient;

    @Autowired
    private NounClient nounClient;

    @GetMapping("/sentence")
    public String getSentence() {
        return nounClient.getWord() + " " + verbClient.getWord() + ".";
    }
}
