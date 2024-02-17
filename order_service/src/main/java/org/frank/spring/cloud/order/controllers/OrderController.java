package org.frank.spring.cloud.order.controllers;

import org.frank.spring.cloud.order.domains.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.frank.spring.cloud.order.services.OrderService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    
    private OrderService orderService;

    @GetMapping("create")
    public Order createOrder(@RequestParam("user_id") Integer userId,
                             @RequestParam("prod_id") Integer prodId){
        return orderService.save(userId,prodId);
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
