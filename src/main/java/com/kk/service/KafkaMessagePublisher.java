package com.kk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageToKafkaTopic(String message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("quickstart-3", message);

        future.whenComplete((result, ex) -> {

            if (ex != null) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            } else {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]" + "partition=[" + result.getRecordMetadata().partition() + "]");
            }
        });
    }

    public void sendMessageToKafkaTopicInBulk(String message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("quickstart-3", message);

        future.whenComplete((result, ex) -> {

            if (ex != null) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            } else {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]" + "partition=[" + result.getRecordMetadata().partition() + "]");
            }
        });
    }

}
