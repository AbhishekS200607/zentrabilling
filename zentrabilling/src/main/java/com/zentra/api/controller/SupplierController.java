package com.zentra.api.controller;

import com.zentra.api.entity.Supplier;
import com.zentra.api.entity.Product;
import com.zentra.api.repository.SupplierRepository;
import com.zentra.api.repository.ProductRepository;
import com.zentra.api.repository.InvoiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin(origins = "*")
public class SupplierController {
    
    @Autowired
    private SupplierRepository supplierRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private InvoiceItemRepository invoiceItemRepository;
    
    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        return supplierRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        return supplierRepository.findById(id)
                .map(existingSupplier -> {
                    supplier.setId(id);
                    return ResponseEntity.ok(supplierRepository.save(supplier));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{id}/products")
    public List<Product> getSupplierProducts(@PathVariable Long id) {
        return productRepository.findByDistributorId(id);
    }
    
    @GetMapping("/{id}/analytics")
    public Map<String, Object> getSupplierAnalytics(@PathVariable Long id) {
        Map<String, Object> analytics = new HashMap<>();
        List<Product> products = productRepository.findByDistributorId(id);
        analytics.put("totalProducts", products.size());
        analytics.put("products", products);
        return analytics;
    }
}