package org.frank.spring.cloud.product.service.impl;

import org.frank.spring.cloud.product.entities.Product;
import org.frank.spring.cloud.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    
    private static final Map<Integer,Product> daoMap = new HashMap<>();
    
    static {
        Product p1 = new Product(1,"iphone12",new BigDecimal("1223.00"),12);
        Product p2 = new Product(2,"iphone13",new BigDecimal("1233.00"),10);
        Product p3 = new Product(3,"iphone14",new BigDecimal("1253.00"),8);
        Product p4 = new Product(4,"iphone15",new BigDecimal("1323.00"),22);
        Product p5 = new Product(5,"iphone16",new BigDecimal("1723.00"),6);
        Product p6 = new Product(6,"iphone17",new BigDecimal("2223.00"),16);
        Product p7 = new Product(7,"iphone18",new BigDecimal("2423.00"),12);
        
        daoMap.put(p1.getId(),p1);
        daoMap.put(p2.getId(),p2);
        daoMap.put(p3.getId(),p3);
        daoMap.put(p4.getId(),p4);
        daoMap.put(p5.getId(),p5);
        daoMap.put(p6.getId(),p6);
        daoMap.put(p7.getId(),p7);
    }
    
    @Override
    public List<Product> listProd() {
        List<Product> productList = new ArrayList<>();
        for(Map.Entry<Integer,Product> entry:daoMap.entrySet()){
            productList.add(entry.getValue());
        }
        return productList;
    }

    @Override
    public Product findProdById(Integer id) {
        return daoMap.get(id);
    }
}
