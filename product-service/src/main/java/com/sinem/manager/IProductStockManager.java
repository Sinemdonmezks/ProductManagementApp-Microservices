package com.sinem.manager;

import com.sinem.dto.request.ProductStockSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import static com.sinem.constants.ApiUrls.SAVE;
import static com.sinem.constants.ApiUrls.UPDATE;

@FeignClient(name="product-stock-service",
        url = "${myapplication.feign.stock}/stock",decode404 = true)
public interface IProductStockManager {

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody ProductStockSaveRequestDto dto);


    }

