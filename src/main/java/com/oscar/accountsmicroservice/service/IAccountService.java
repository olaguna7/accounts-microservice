package com.oscar.accountsmicroservice.service;

import com.oscar.accountsmicroservice.dto.CustomerDTO;

public interface IAccountService {

    /**
     *
     * @param customer - CustomerDTO object
     */
    void createAccount(CustomerDTO customer);

    /**
     *
     * @param mobileNumber - Input mobile number
     * @return Accounts Details based on a given mobile number
     */
    CustomerDTO fetchAccount(String mobileNumber);

    /**
     *
     * @param customerDTO - CustomerDTO object
     * @return boolean indicating if the update of the Account details is successful or not
     */
    boolean updateAccount(CustomerDTO customerDTO);

}
