package com.zentra.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private String phone;
    private String email;
    private String address;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}