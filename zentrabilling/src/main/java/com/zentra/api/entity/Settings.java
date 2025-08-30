package com.zentra.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "settings")
@Data
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "business_name")
    private String businessName;
    
    private String gstin;
    private String address;
    private String phone;
    private String email;
    
    @Lob
    private String logo;
    
    @Lob
    @Column(name = "upi_qr")
    private String upiQr;
    
    @Column(name = "default_tax_rate", precision = 5, scale = 2)
    private BigDecimal defaultTaxRate = new BigDecimal("18.00");
    
    @Column(name = "bank_name")
    private String bankName;
    
    @Column(name = "account_number")
    private String accountNumber;
    
    @Column(name = "ifsc_code")
    private String ifscCode;
    
    @Column(name = "account_holder_name")
    private String accountHolderName;
}