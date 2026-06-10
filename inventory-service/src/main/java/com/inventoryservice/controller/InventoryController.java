package com.inventoryservice.controller;

import com.inventoryservice.service.InventoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{productId}")
    public String checkInventory(@PathVariable String productId) {
        return inventoryService.checkInventory(productId);
    }

    @PatchMapping("/{productId}")
    public String updateInventory(@PathVariable String productId, @RequestBody int quantity) {
        return inventoryService.updateInventory(productId, quantity);
    }
}
