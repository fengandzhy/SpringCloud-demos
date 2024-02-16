package org.frank.spring.cloud.product.controllers;

import org.frank.spring.cloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.frank.spring.cloud.product.entities.Product;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    
    private ProductService productService;
    
    @GetMapping("list")
    public List<Product> listProd(){
        return productService.listProd();
    }
    
    @GetMapping("find")
    public Product findProdById(@RequestParam("id") Integer id) {
        return productService.findProdById(id);
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
