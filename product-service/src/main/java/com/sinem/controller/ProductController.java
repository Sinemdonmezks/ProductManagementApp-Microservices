package com.sinem.controller;

import com.sinem.dto.request.ProductSaveRequestDto;
import com.sinem.dto.response.ProductSaveResponseDto;
import com.sinem.repository.entity.Product;
import com.sinem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.sinem.constants.ApiUrls.*;

@RestController
@RequestMapping(PRODUCT)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @PostMapping(SAVE)
    public ResponseEntity<ProductSaveResponseDto> save(@RequestBody ProductSaveRequestDto dto){
        return ResponseEntity.ok(productService.save(dto));
    }

    @GetMapping(PRODUCT_LIST)
    public ResponseEntity<List<Product>> productList(){
      return   ResponseEntity.ok(productService.findAll());
    }
}


