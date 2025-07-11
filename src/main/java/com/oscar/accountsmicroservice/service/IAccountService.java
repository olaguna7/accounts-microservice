package com.oscar.accountsmicroservice.service;

import com.oscar.accountsmicroservice.dto.CustomerDTO;

public interface IAccountService {
    void createAccount(CustomerDTO customer);

}
