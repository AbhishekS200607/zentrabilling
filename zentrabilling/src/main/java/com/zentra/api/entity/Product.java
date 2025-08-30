package com.zentra.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(unique = true)
    private String barcode;
    
    private String description;
    private String category;
    private String brand;
    private String unit;
    private String hsn;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    
    @Column(name = "cost_price", precision = 10, scale = 2)
    private BigDecimal costPrice;
    
    @Column(name = "selling_price", precision = 10, scale = 2)
    private BigDecimal sellingPrice;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal mrp;
    
    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;
    
    @Column(nullable = false)
    private Integer stock;
    
    @Column(name = "low_stock_threshold")
    private Integer lowStockThreshold = 10;
    
    @Column(name = "reorder_level")
    private Integer reorderLevel;
    
    @Column(name = "tax_rate", precision = 5, scale = 2)
    private BigDecimal taxRate;
    
    @Column(name = "is_active")
    private Boolean isActive = true;
    
    @Column(name = "distributor_id")
    private Long distributorId;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}