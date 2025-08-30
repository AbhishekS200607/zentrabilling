package com.zentra.api.controller;

import com.zentra.api.entity.InvoiceItem;
import com.zentra.api.repository.InvoiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/invoice-items")
@CrossOrigin(origins = "*")
public class InvoiceItemController {
    
    @Autowired
    private InvoiceItemRepository invoiceItemRepository;
    
    @PostMapping
    public InvoiceItem createInvoiceItem(@RequestBody InvoiceItem invoiceItem) {
        return invoiceItemRepository.save(invoiceItem);
    }
    
    @GetMapping("/invoice/{invoiceId}")
    public List<InvoiceItem> getInvoiceItems(@PathVariable Long invoiceId) {
        return invoiceItemRepository.findByInvoiceId(invoiceId);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoiceItem(@PathVariable Long id) {
        invoiceItemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}