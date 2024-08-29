package com.ads.dealshop.dto;




import com.ads.dealshop.entity.Product;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

public class ProductDto {
	private Long id;
  private String category;
  private String description;
  private String img_path;
  private String type;
  private String reference;
  private String name;
  private String status;
  private Integer price;
  private Integer discounted_price;
  
 public ProductDto(Product product) {
	 id=product.getId();
	 category=product.getCategory();
	 description=product.getDescription();
	 img_path=product.getImg_path();
	 type=product.getType();
	 reference=product.getReference();
	 name=product.getName();
	 status=product.getStatus();
	 price=product.getPrice();
	 discounted_price=product.getDiscounted_price();
 }
 public Product convert() {
	 Product product = new Product();
	 product.setId(id);
	 product.setName(name);
	 product.setDescription(description);
	 product.setCategory(category);
	 product.setType(type);
	 product.setStatus(status);
	 product.setReference(reference);
	 product.setPrice(price);
	 product.setDiscounted_price(discounted_price);
	 product.setImg_path(img_path);
	 return product;
 }
}
 