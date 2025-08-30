package com.zentra.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "suppliers")
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private String phone;
    private String email;
    private String address;
    
    @Column(name = "total_purchases", precision = 10, scale = 2)
    private BigDecimal totalPurchases = BigDecimal.ZERO;
    
    @Column(name = "total_payments", precision = 10, scale = 2)
    private BigDecimal totalPayments = BigDecimal.ZERO;
    
    @Column(name = "balance_due", precision = 10, scale = 2)
    private BigDecimal balanceDue = BigDecimal.ZERO;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}