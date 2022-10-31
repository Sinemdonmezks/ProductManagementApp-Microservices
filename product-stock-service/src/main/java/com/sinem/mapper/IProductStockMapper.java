package com.sinem.mapper;

import com.sinem.dto.request.StockUpdateRequestDto;
import com.sinem.repository.entity.ProductStock;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductStockMapper {
    IProductStockMapper INSTANCE= Mappers.getMapper(IProductStockMapper.class);

    ProductStock toProductStock(final StockUpdateRequestDto dto);
    StockUpdateRequestDto toStockCreateRequestDto(final ProductStock productStock );


}
