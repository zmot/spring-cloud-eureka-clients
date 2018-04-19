package com.tm.microservices.eureka.client.word;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class WordController {

    @Value("${words}")
    private List<String> words;

    @GetMapping("/")
    public String getWord(){
        return words.get(new Random().nextInt(words.size()));
    }
}
