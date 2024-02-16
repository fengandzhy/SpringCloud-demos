package org.frank.spring.cloud.order.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.frank.spring.cloud.order.services.OrderService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    
    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
