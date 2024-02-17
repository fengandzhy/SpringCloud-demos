package org.frank.spring.cloud.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="product-service")
public interface ProductClient {
    
    @GetMapping("/api/v1/product/find")
    String findProdById(@RequestParam("id") Integer id);
}
