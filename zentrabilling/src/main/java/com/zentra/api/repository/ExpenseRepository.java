package com.zentra.api.repository;

import com.zentra.api.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.expenseDate = :date")
    BigDecimal getTodayExpenses(LocalDate date);
    
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE MONTH(e.expenseDate) = MONTH(:date) AND YEAR(e.expenseDate) = YEAR(:date)")
    BigDecimal getMonthlyExpenses(LocalDate date);
}