package com.orderservice.controller;

import com.orderservice.dto.OrderRequest;
import com.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{productId}")
    public String placeOrder(@PathVariable String productId, @RequestBody OrderRequest orderRequest) {
        return orderService.placeOrder(productId, orderRequest.getQuantity());
    }
}
