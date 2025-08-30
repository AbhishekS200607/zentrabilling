package com.zentra.api.service;

import com.zentra.api.entity.Invoice;
import com.zentra.api.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    
    @Autowired
    private InvoiceRepository invoiceRepository;
    
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }
    
    public Optional<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }
    
    public Invoice saveInvoice(Invoice invoice) {
        if (invoice.getInvoiceNumber() == null) {
            invoice.setInvoiceNumber(generateInvoiceNumber());
        }
        if (invoice.getInvoiceDate() == null) {
            invoice.setInvoiceDate(LocalDate.now());
        }
        return invoiceRepository.save(invoice);
    }
    
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
    
    private String generateInvoiceNumber() {
        String datePrefix = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        long count = invoiceRepository.count() + 1;
        return "INV-" + datePrefix + "-" + String.format("%04d", count);
    }
}