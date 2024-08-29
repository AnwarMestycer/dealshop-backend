package com.ads.dealshop.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ads.dealshop.dto.ProductDto;
import com.ads.dealshop.service.ProductService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController

@RequestMapping(value="/rest")
public class ProductController {
	
	@Autowired
	private ProductService productService;
  
  @PostMapping(value="/add")
  public void addProduct(@RequestBody ProductDto product) {
	  productService.addProduct(product);

  }
  @GetMapping(value="/load/{productId}")
  public ProductDto loadContact(@PathVariable("productId") long productId) {
	  log.info("loading");
    return productService.loadProduct(productId);
  }
  @GetMapping(value="/load-list")
  public List<ProductDto> loadProducttList() {
    return productService.laodProductList();
  }
  @GetMapping(value="/categories")
  public List<String> getDistinctCategories() {
      return productService.getAllCategories();
  }
  @GetMapping("/category/{category}")
  public List<ProductDto> getProductsByCategory(@PathVariable String category) {
      return productService.findProductsByCategory(category);

  }
  @GetMapping("/status/{status}")
  public List<ProductDto> findByStatus(@PathVariable String status) {
      return productService.findByStatus(status);

  }
  
 
} 
