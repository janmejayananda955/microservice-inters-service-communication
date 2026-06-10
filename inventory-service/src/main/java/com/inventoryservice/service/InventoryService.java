package com.inventoryservice.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InventoryService {
    private final Map<String, Integer> inventory = new HashMap<>();

    public InventoryService() {
        inventory.put("1", 10);
        inventory.put("2", 20);
    }

    public String checkInventory(String productId) {
        return inventory.containsKey(productId) ? "IN STOCK" : "OUT OF STOCK";
//        return productId.equals("1") ? "IN STOCK" : "OUT OF STOCK";
    }

    public String updateInventory(String productId, int quantity) {
        if (inventory.containsKey(productId) && inventory.get(productId) >= quantity) {
            inventory.put(productId, inventory.get(productId) - quantity);
            return "Order placed successfully";
        }
        return "Out of stock";
    }
}
