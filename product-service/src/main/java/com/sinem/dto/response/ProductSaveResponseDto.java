package com.sinem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductSaveResponseDto {
    private String name;
    private String brand;
    private String model;
    private Double price;
   // private Integer stock;
    private Long created;
}
