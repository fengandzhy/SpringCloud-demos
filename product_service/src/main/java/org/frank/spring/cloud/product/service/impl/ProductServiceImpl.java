package org.frank.spring.cloud.product.service.impl;

import org.frank.spring.cloud.product.entities.Product;
import org.frank.spring.cloud.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    
    private static final Map<Integer,Product> daoMap = new HashMap<>();
    
    static {
        
    }
    
    @Override
    public List<Product> listProd() {
        return null;
    }

    @Override
    public Product findProdById(Integer id) {
        return null;
    }
}
