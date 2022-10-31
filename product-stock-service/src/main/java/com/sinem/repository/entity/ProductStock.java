package com.sinem.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private Long productid;
    private String name;
    private String brand;
    private String model;
    private Double price;
    private Integer stock;
}
