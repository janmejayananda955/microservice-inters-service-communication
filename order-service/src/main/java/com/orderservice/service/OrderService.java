package com.orderservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    private final RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String placeOrder(String productId) {
        // TODO: call product service to check stack
        String response = restTemplate.getForObject(
                "http://localhost:8082/api/inventory/" + productId,
                String.class
        );
        return "IN STOCK".equals(response) ? "Order Placed Successfully" : response;
    }
}
