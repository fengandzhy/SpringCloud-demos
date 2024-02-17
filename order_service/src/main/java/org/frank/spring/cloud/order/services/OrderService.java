package org.frank.spring.cloud.order.services;

import org.frank.spring.cloud.order.domains.Order;

public interface OrderService {

    public Order save(int userId, int productId);
}
