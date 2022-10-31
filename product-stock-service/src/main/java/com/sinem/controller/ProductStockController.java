package com.sinem.controller;

import com.sinem.dto.request.ProductStockSaveRequestDto;
import com.sinem.dto.request.StockUpdateRequestDto;
import com.sinem.exception.ErrorType;
import com.sinem.exception.ProductStockServiceException;
import com.sinem.repository.entity.ProductStock;
import com.sinem.service.ProductStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sinem.constants.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(STOCK)
public class ProductStockController {
    private final ProductStockService productStockService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody ProductStockSaveRequestDto dto){
        return ResponseEntity.ok(productStockService.save(dto));
    }

    @PostMapping(UPDATE)
    public ResponseEntity<ProductStock> update(@RequestBody StockUpdateRequestDto dto){

        try {
            return ResponseEntity.ok(productStockService.updateStock(dto));
        }catch (Exception e){
            throw  new ProductStockServiceException(ErrorType.STOCK_NOT_CREATED);
        }

    }
    @GetMapping(STOCK_LIST)
    public ResponseEntity<List<ProductStock>> productList(){
        return   ResponseEntity.ok(productStockService.findAll());
    }


}
