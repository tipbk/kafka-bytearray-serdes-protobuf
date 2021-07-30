package com.example.kafkaproducer.controller;

import com.example.kafka.producer.type.*;
import com.example.kafkaproducer.model.User;
import com.google.protobuf.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String,byte[]> kafkaTemplate;


    @GetMapping("/test")
    public String test() {
        return "Working!";
    }

    @GetMapping("/tip/{message}")
    public String tip(@PathVariable String message) {
        List<String> wives = new ArrayList<>();
        wives.add("Chuu");
        wives.add("Chaewon");
        TipMessage tipMessage = TipMessage.newBuilder()
                .setFirst(TipFirst.newBuilder()
                        .setMessage(message))
                .setSecond(TipSecond.newBuilder()
                        .addAllWivesName(wives)
                        .setId("This is ID at Second"))
                .build();
        kafkaTemplate.send("tip.topic", tipMessage.toByteArray());
        return message + " published at Tip.topic";
    }
}
