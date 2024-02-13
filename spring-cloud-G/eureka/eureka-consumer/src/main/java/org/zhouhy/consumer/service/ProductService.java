package org.zhouhy.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.zhouhy.consumer.domain.Product;

import java.util.List;

@Service
public class ProductService {
    
    @Autowired
    private LoadBalancerClient loadBalancerClient;    
    
    public List<Product> listProduct(){
        //它会到eureka server里面去找到所有的provider 然后算出哪一个provider 可用
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka.provider");
        StringBuffer sb = new StringBuffer();
        sb.append("http://");
        sb.append(serviceInstance.getHost());
        sb.append(":");
        sb.append(serviceInstance.getPort());
        sb.append("/product/list");
        
        System.out.println(sb.toString());

        RestTemplate restTemplate = new RestTemplate();
        ParameterizedTypeReference<List<Product>> typeReference 
                = new ParameterizedTypeReference<List<Product>>(){};
        ResponseEntity<List<Product>> responseEntity 
                = restTemplate.exchange(sb.toString(), HttpMethod.GET,null,typeReference);
        List<Product> products = responseEntity.getBody();               
        return products;
    }
}
