package com.ads.dealshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="Product")
@Data
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="ProductId")
  private Long id;
  @Column(name="Name")
  private String name;
  @Column(name="Description")
  private String description;
  @Column(name="Category")
  private String category;
  @Column(name="Img_path")
  private String img_path;
  @Column(name="Type")
  private String type;
  @Column(name="Reference")
  private String reference;
  @Column(name="Status")
  private String status;
  @Column(name="Price")
  private Integer price;
  @Column(name="Discounted_price")
  private Integer discounted_price;
}

