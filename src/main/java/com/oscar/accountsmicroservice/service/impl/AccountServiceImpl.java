package com.oscar.accountsmicroservice.service.impl;

import com.oscar.accountsmicroservice.dto.CustomerDTO;
import com.oscar.accountsmicroservice.repository.AccountRepository;
import com.oscar.accountsmicroservice.repository.CustomerRepository;
import com.oscar.accountsmicroservice.service.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void createAccount(CustomerDTO customer) {

    }
}
