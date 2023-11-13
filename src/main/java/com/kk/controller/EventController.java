package com.kk.controller;

import com.kk.dto.EmployeeDetails;
import com.kk.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        for (int i = 0; i < 1000; i++) {
            kafkaMessagePublisher.sendMessageToKafkaTopicInBulk(message + " " + i);

        }
        return ResponseEntity.ok("Message published successfully");
    }

    @PostMapping("/publishEventMessage")
    public void publishEventMessage(@RequestBody EmployeeDetails employeeDetails) {


            kafkaMessagePublisher.sendEventMessageToKafkaTopic(employeeDetails);


    }
}