package com.ads.dealshop.service;


import java.util.List;


import com.ads.dealshop.dto.ProductDto;


public interface ProductService {
void addProduct(ProductDto product);
ProductDto loadProduct(long productId);
public List<ProductDto> laodProductList();
public List<String> getAllCategories();
public List<ProductDto> findProductsByCategory(String category);
public List<ProductDto> findByStatus(String status);

}
