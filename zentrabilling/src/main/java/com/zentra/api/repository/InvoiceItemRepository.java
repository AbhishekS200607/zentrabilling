package com.zentra.api.repository;

import com.zentra.api.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
    
    List<InvoiceItem> findByInvoiceId(Long invoiceId);
    
    @Query("SELECT ii FROM InvoiceItem ii WHERE ii.productId IN (SELECT p.id FROM Product p WHERE p.distributorId = :distributorId)")
    List<InvoiceItem> findByDistributorId(@Param("distributorId") Long distributorId);
}