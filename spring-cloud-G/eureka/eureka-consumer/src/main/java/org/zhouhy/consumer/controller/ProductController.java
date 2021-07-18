package org.zhouhy.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.consumer.domain.Product;
import org.zhouhy.consumer.service.ProductService;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value="/list",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public List<Product> listProduct(){
        List<Product> list = this.productService.listProduct();
        return list;
    }
}
