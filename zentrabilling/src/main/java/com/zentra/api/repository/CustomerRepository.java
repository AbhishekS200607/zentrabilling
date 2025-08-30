package com.zentra.api.repository;

import com.zentra.api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    @Query("SELECT c FROM Customer c WHERE c.name LIKE %:search% OR c.phone LIKE %:search% OR c.email LIKE %:search%")
    List<Customer> findByNameOrPhoneOrEmailContaining(@Param("search") String search);
}