package com.oscar.accountsmicroservice.repository;

import com.oscar.accountsmicroservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByCustomerId(Long customerId);

}
