package org.frank.spring.cloud.product.service;


import org.frank.spring.cloud.product.entities.Product;
import java.util.List;

public interface ProductService {
    
    public List<Product> listProd();
    
    public Product findProdById(Integer id);
}
