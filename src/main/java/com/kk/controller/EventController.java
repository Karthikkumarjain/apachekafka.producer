package com.kk.controller;

import com.kk.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer-event")
public class EventController {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {
        kafkaMessagePublisher.sendMessageToKafkaTopic(message);
        return ResponseEntity.ok("Message published successfully");
    }

    @GetMapping("/publishbulk/{message}")
    public ResponseEntity<?> publishMessageInBulk(@PathVariable String message) {

        for (int i = 0; i < 10000; i++) {
            kafkaMessagePublisher.sendMessageToKafkaTopicInBulk(message + " " + i);

        }
        return ResponseEntity.ok("Message published successfully");
    }
}