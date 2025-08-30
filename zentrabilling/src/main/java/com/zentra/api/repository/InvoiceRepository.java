package com.zentra.api.repository;

import com.zentra.api.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
    @Query("SELECT COALESCE(SUM(i.grandTotal), 0) FROM Invoice i WHERE i.invoiceDate = :date")
    BigDecimal getTodayRevenue(LocalDate date);
    
    @Query("SELECT COALESCE(SUM(i.grandTotal), 0) FROM Invoice i WHERE MONTH(i.invoiceDate) = MONTH(:date) AND YEAR(i.invoiceDate) = YEAR(:date)")
    BigDecimal getMonthlyRevenue(LocalDate date);
    
    @Query("SELECT COUNT(i) FROM Invoice i WHERE i.invoiceDate = :date")
    Long getTodayInvoiceCount(LocalDate date);
}