package com.sinem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductStockSaveRequestDto {
    private Long productid;
    private String name;
    private String brand;
    private String model;
    private Double price;
    private Integer quantity;
    private Integer stock;
}
