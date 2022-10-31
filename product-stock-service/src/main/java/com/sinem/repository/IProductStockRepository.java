package com.sinem.repository;

import com.sinem.repository.entity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductStockRepository extends JpaRepository<ProductStock,Long> {

    Optional<ProductStock> findOptionalByProductid(Long productid);
}
