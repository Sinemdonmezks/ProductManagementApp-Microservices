package com.sinem.service;

import com.sinem.dto.request.ProductSaveRequestDto;
import com.sinem.dto.request.ProductStockSaveRequestDto;
import com.sinem.dto.response.ProductSaveResponseDto;
import com.sinem.exception.ErrorType;
import com.sinem.exception.ProductServiceException;
import com.sinem.manager.IProductStockManager;
import com.sinem.mapper.IProductMapper;
import com.sinem.repository.IProductRepository;
import com.sinem.repository.entity.Product;
import com.sinem.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceManager<Product,Long> {
    private final IProductRepository productRepository;
    private final IProductStockManager productStockManager;
    public ProductService(IProductRepository productRepository,IProductStockManager productStockManager){
        super(productRepository);
        this.productRepository=productRepository;
        this.productStockManager=productStockManager;
    }

    public ProductSaveResponseDto save(ProductSaveRequestDto dto) {
        Product product = IProductMapper.INSTANCE.toProduct(dto);
        try {

            save(product);
            productStockManager.save(ProductStockSaveRequestDto.builder()
                            .productid(product.getId())
                            .brand(product.getBrand())
                            .model(product.getModel())
                            .name(product.getName())
                            .price(product.getPrice())
                            .stock(product.getQuantity())
                    .build());
            return IProductMapper.INSTANCE.toProductSaveResponseDto(product);
        } catch (ProductServiceException e) {
            throw new ProductServiceException(ErrorType.PRODUCT_NOT_CREATED);
        }
    }

}
