package org.frank.spring.cloud.product.controllers;

import org.frank.spring.cloud.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    
    @Value("${server.port}")
    private String port;
    
    @GetMapping("list")
    public List<Product> listProd(){
        return productService.listProd();
    }
    
    @GetMapping("find")
    public Product findProdById(@RequestParam("id") Integer id) {
        Product product = productService.findProdById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product,result);
        result.setName( result.getName() + " data from port="+port );
        return result;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
