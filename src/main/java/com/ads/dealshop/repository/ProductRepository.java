package com.ads.dealshop.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ads.dealshop.entity.Product;
public interface ProductRepository extends CrudRepository<Product,Long> {
	@Query("SELECT DISTINCT p.category FROM Product p")
    List<String> findAllCategories();
	
	@Query("SELECT p FROM Product p WHERE p.category = :category")
	List<Product> findByCategory(@Param("category") String category);
	
	@Query("SELECT p FROM Product p WHERE p.status = :status")
	List<Product> findByStatus(@Param("status") String status);


	
			 
}
