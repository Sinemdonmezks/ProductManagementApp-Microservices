package com.sinem.mapper;
import com.sinem.dto.request.ProductSaveRequestDto;
import com.sinem.dto.response.ProductSaveResponseDto;
import com.sinem.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface IProductMapper {
    IProductMapper INSTANCE= Mappers.getMapper(IProductMapper.class);

    Product toProduct(final ProductSaveRequestDto dto);
    ProductSaveRequestDto toProductSaveRequestDto(final Product product);
    ProductSaveResponseDto toProductSaveResponseDto(final Product product);
    Product toProduct(final ProductSaveResponseDto dto);
}
