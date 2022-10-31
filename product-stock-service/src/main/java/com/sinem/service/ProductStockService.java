package com.sinem.service;

import com.sinem.dto.request.ProductStockSaveRequestDto;
import com.sinem.dto.request.StockUpdateRequestDto;
import com.sinem.exception.ErrorType;
import com.sinem.exception.ProductStockServiceException;
import com.sinem.mapper.IProductStockMapper;
import com.sinem.repository.IProductStockRepository;
import com.sinem.repository.entity.ProductStock;
import com.sinem.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductStockService extends ServiceManager<ProductStock,Long> {

private final IProductStockRepository productStockRepository;
public ProductStockService(IProductStockRepository productStockRepository){
    super(productStockRepository);
    this.productStockRepository=productStockRepository;
}

public Boolean save (ProductStockSaveRequestDto dto){
    ProductStock productStock=save(ProductStock.builder()
            .name(dto.getName())
            .brand(dto.getBrand())
            .price(dto.getPrice())
            .model(dto.getModel())
            .productid(dto.getProductid())
            .stock(dto.getStock())
            .build());

    return true;
}

    public ProductStock updateStock(StockUpdateRequestDto dto){

        Optional<ProductStock> productStock=
                productStockRepository.findOptionalByProductid(dto.getProductid());
        if(productStock.isEmpty()) throw new ProductStockServiceException(ErrorType.PRODUCT_NOT_FOUND);
       productStock.get().setStock(dto.getStock()+productStock.get().getStock());


       return save(productStock.get());
    }
}
