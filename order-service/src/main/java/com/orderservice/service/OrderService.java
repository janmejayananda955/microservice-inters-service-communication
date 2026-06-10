package com.orderservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class OrderService {
    // private final RestTemplate restTemplate;
    private final RestClient restClient;

    public OrderService(RestClient restClient) {
        // this.restTemplate = restTemplate;
        this.restClient = restClient;
    }

    public String placeOrder(String productId, int quantity) {
        // TODO: call product service to check stack
        /* // Using RestTemplate
        String response = restTemplate.getForObject(
                "http://localhost:8082/api/inventory/" + productId,
                String.class
        ); **/

        // Using RestClient
//        String response = restClient.get()
//                .uri("http://localhost:8082/api/inventory/{productId}", productId)
//                .retrieve()
//                .body(String.class);

        String updateResponse = updateInventory(productId, quantity);
        if ("Out of stock".equals(updateResponse)) {
            return "Product out of Stock";
        }
        return "Order Placed Successfully";

    }

    private String updateInventory(String productId, int quantity) {
        return (restClient.patch()
                .uri("http://localhost:8082/api/inventory/{productId}", productId)
                .body(quantity)
                .retrieve()
                .body(String.class));
    }
}
