package com.zentra.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "invoice_number", unique = true, nullable = false)
    private String invoiceNumber;
    
    @Column(name = "customer_id")
    private Long customerId;
    
    @Column(name = "invoice_date")
    private LocalDate invoiceDate;
    
    @Column(name = "due_date")
    private LocalDate dueDate;
    
    @Column(name = "reference_number")
    private String referenceNumber;
    
    private String notes;
    private String terms;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;
    
    @Column(name = "discount_amount", precision = 10, scale = 2)
    private BigDecimal discountAmount;
    
    @Column(name = "discount_percentage", precision = 5, scale = 2)
    private BigDecimal discountPercentage;
    
    @Column(name = "tax_rate", precision = 5, scale = 2)
    private BigDecimal taxRate;
    
    @Column(name = "tax_amount", precision = 10, scale = 2)
    private BigDecimal taxAmount;
    
    @Column(name = "shipping_charges", precision = 10, scale = 2)
    private BigDecimal shippingCharges;
    
    @Column(name = "other_charges", precision = 10, scale = 2)
    private BigDecimal otherCharges;
    
    @Column(name = "round_off", precision = 10, scale = 2)
    private BigDecimal roundOff;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;
    
    @Column(name = "grand_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal grandTotal;
    
    @Column(name = "paid_amount", precision = 10, scale = 2)
    private BigDecimal paidAmount;
    
    @Column(name = "balance_amount", precision = 10, scale = 2)
    private BigDecimal balanceAmount;
    
    @Enumerated(EnumType.STRING)
    private InvoiceStatus status = InvoiceStatus.UNPAID;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus = PaymentStatus.UNPAID;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;
    
    @Column(name = "invoice_type")
    private String invoiceType;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "paid_at")
    private LocalDateTime paidAt;
    
    public enum InvoiceStatus {
        PAID, UNPAID
    }
    
    public enum PaymentStatus {
        PAID, UNPAID
    }
    
    public enum PaymentMethod {
        CASH, UPI, CARD
    }
}