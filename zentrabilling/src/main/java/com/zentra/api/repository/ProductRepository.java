package com.zentra.api.repository;

import com.zentra.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:search% OR p.barcode LIKE %:search%")
    List<Product> findByNameOrBarcodeContaining(@Param("search") String search);
    
    @Query("SELECT p FROM Product p WHERE p.stock <= p.lowStockThreshold")
    List<Product> findLowStockProducts();
    
    @Query("SELECT COUNT(p) FROM Product p WHERE p.stock <= p.lowStockThreshold")
    Long countLowStockProducts();
    
    List<Product> findByDistributorId(Long distributorId);
}