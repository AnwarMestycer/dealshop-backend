package com.ads.dealshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ads.dealshop.dto.ProductDto;
import com.ads.dealshop.entity.Product;
import com.ads.dealshop.repository.ProductRepository;
import com.ads.dealshop.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductIServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Override
	public void addProduct(ProductDto product) {
		log.info("start saving, productId={}", product.toString());
		Product p = product.convert();
		log.info("before productId ={}", p.getId());
		productRepository.save(p);
		log.info("After ProductId ={}", p.getId()); }
	
	@Override
	  public ProductDto loadProduct(long productId) {

	    log.info("Loading product, productId={}",productId);
	 
	    // loading the entity product
	    Product c=productRepository.findById(productId).get();
	    log.info("Product loaded succesfully, Product={}",c.toString());
	 
	    // convert from entity to dto
	    ProductDto product=new ProductDto(c);
	    log.info("Entity converted to dto , ProductDto={}",product.toString());
	 
	    return product;
	  }
	@Override
	  public List<ProductDto> laodProductList() {
	    log.info("Loading product list");
	 
	    // loading product list
	    List<Product> list=(List<Product>) productRepository.findAll();
	 
	    // convert from entities to dtos
	    List<ProductDto> productList=new ArrayList<ProductDto>();
	    for(Product c:list)
	      productList.add(new ProductDto(c));
	 
	    log.info("Product list loaded succesfully, productList={}",productList.toString());
	    return productList;
	  }
	 public List<String> getAllCategories() {
	        return productRepository.findAllCategories();
	    }
	 public List<ProductDto> findProductsByCategory(String category) {
	        List<Product> list=(List<Product>) productRepository.findByCategory(category);
	   	 
		    // convert from entities to dtos
		    List<ProductDto> productByCategoryList=new ArrayList<ProductDto>();
		    for(Product c:list)
		    	productByCategoryList.add(new ProductDto(c));
		 
		    log.info("Product list loaded succesfully, productList={}",productByCategoryList.toString());
		    return productByCategoryList;
	 
	    }

	@Override
	public List<ProductDto> findByStatus(String status) {
		  List<Product> list=(List<Product>) productRepository.findByStatus(status);
		   	 
		    // convert from entities to dtos
		    List<ProductDto> productByStatusList=new ArrayList<ProductDto>();
		    for(Product c:list)
		    	productByStatusList.add(new ProductDto(c));
		 
		    log.info("Product status list loaded succesfully, productStatusList={}",productByStatusList.toString());
		    return productByStatusList;
	}


}
