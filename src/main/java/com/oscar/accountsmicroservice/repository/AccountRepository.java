package com.oscar.accountsmicroservice.repository;

import com.oscar.accountsmicroservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
