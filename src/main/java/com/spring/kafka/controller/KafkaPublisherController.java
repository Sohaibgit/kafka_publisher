package com.spring.kafka.controller;

import com.spring.kafka.entity.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaPublisherController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaPublisherController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/publish/{name}")
    public String publishMessage(@PathVariable String name){
        kafkaTemplate.send("mytopic1", "Hi " + name + ", Welcome to Kafka publisher");

        return "Data published successfully";
    }

    @GetMapping("/publish/object")
    public String publishObject(){
        User user = new User(1, "Sohaib", "Khan", new String[]{"Islamabad", "Lahore", "Karachi"});
        kafkaTemplate.send("mytopic1", user);

        return "Data published successfully";
    }
}
