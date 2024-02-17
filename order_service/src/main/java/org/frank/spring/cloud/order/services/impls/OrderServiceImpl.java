package org.frank.spring.cloud.order.services.impls;

import org.frank.spring.cloud.order.domains.Order;
import org.frank.spring.cloud.order.domains.OrderItem;
import org.frank.spring.cloud.order.domains.Product;
import org.frank.spring.cloud.order.domains.User;
import org.frank.spring.cloud.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {
    
    private RestTemplate restTemplate;
    
    @Override
    public Order save(int userId, int productId) {
        Product product = restTemplate.getForObject("http://product-service/api/v1/product/find?id="+productId, Product.class);

        //调用方式二
//        ServiceInstance instance = loadBalancer.choose("product-service");
//        String url = String.format("http://%s:%s/api/v1/product/find?id="+productId, instance.getHost(),instance.getPort());
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String,Object> productMap = restTemplate.getForObject(url, Map.class);
        
        System.out.println(product.getName());
        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setQuantity(1);
        
        Order order = new Order();
        order.getOrderItemList().add(item);
        
        User user = new User();
        user.setId(userId);
        order.setUser(user);
        
        return order;        
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
