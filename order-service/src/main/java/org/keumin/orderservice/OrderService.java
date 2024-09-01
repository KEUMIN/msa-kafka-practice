package org.keumin.orderservice;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class OrderService {
    private final RestTemplate restTemplate;
    private final KafkaTemplate<String, String> kafkaTemplate; // 배울 것

    public Order createOrder(Order order) {
        // 사용자 서비스에서 사용자 정보 조회 (예시)
        // User user = restTemplate.getForObject("http://user-service/users/{id}", User.class, order.getUserId());

        // 주문 저장 로직 (예시)
        Order savedOrder = order;
        savedOrder.setId(System.currentTimeMillis());  // 임시 ID 생성

        // Kafka로 메시지 전송 배울 것
        kafkaTemplate.send("order-created-topic", "New order created for user: " + order.getUserId());

        return savedOrder;
    }
}