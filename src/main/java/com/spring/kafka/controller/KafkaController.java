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
public class KafkaController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/publish/{name}")
    public String publishMessage(@PathVariable String name){
        kafkaTemplate.send("mytopic1", "Hi " + name + ", Welcome to Kafka publisher");

        return "Data published successfully";
    }

    @GetMapping("/publish/object")
    public String publishObject(){
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Sohaib", "Khan", new String[]{"Islamabad", "Lahore", "Karachi"}));
        userList.add(new User(1, "Aslam", "Khan", new String[]{"Islamabad", "Faisalabad", "Karachi"}));
        userList.add(new User(1, "Akram", "Khan", new String[]{"Islamabad", "Bahawalpur", "Karachi"}));
        userList.add(new User(1, "Daniyal", "Khan", new String[]{"Islamabad", "Hyderabad", "Karachi"}));
        userList.add(new User(1, "Saif", "Khan", new String[]{"Islamabad", "Taxila", "Karachi"}));

        kafkaTemplate.send("mytopic1", userList);
        return "Data published successfully";
    }
}
