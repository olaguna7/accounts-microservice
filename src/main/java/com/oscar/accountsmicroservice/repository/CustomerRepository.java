package com.oscar.accountsmicroservice.repository;

import com.oscar.accountsmicroservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
