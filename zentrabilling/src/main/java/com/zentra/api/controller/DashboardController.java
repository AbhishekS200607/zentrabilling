package com.zentra.api.controller;

import com.zentra.api.repository.InvoiceRepository;
import com.zentra.api.repository.ExpenseRepository;
import com.zentra.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {
    
    @Autowired
    private InvoiceRepository invoiceRepository;
    
    @Autowired
    private ExpenseRepository expenseRepository;
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("/stats")
    public Map<String, Object> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        LocalDate today = LocalDate.now();
        
        BigDecimal todayRevenue = invoiceRepository.getTodayRevenue(today);
        BigDecimal monthlyRevenue = invoiceRepository.getMonthlyRevenue(today);
        BigDecimal todayExpenses = expenseRepository.getTodayExpenses(today);
        BigDecimal monthlyExpenses = expenseRepository.getMonthlyExpenses(today);
        Long todayInvoices = invoiceRepository.getTodayInvoiceCount(today);
        Long lowStockCount = productService.getLowStockCount();
        
        stats.put("todayRevenue", todayRevenue);
        stats.put("monthlyRevenue", monthlyRevenue);
        stats.put("todayExpenses", todayExpenses);
        stats.put("monthlyExpenses", monthlyExpenses);
        stats.put("todayProfit", todayRevenue.subtract(todayExpenses));
        stats.put("monthlyProfit", monthlyRevenue.subtract(monthlyExpenses));
        stats.put("todayInvoices", todayInvoices);
        stats.put("lowStockCount", lowStockCount);
        
        return stats;
    }
}