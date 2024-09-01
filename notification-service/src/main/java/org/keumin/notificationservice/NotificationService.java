package org.keumin.notificationservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @KafkaListener(topics = "order-created-topic", groupId = "notification-group")
    public void consumeMessages(String message) {
        System.out.println("Received Notification : " + message);
        // Here you would add your notification logic (e.g., sending an email)
    }
}
