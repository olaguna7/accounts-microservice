package com.oscar.accountsmicroservice.service.impl;

import com.oscar.accountsmicroservice.constants.AccountConstants;
import com.oscar.accountsmicroservice.dto.AccountDTO;
import com.oscar.accountsmicroservice.dto.CustomerDTO;
import com.oscar.accountsmicroservice.entity.Account;
import com.oscar.accountsmicroservice.entity.Customer;
import com.oscar.accountsmicroservice.exception.CustomerAlreadyExistsException;
import com.oscar.accountsmicroservice.exception.ResourceNotFoundException;
import com.oscar.accountsmicroservice.mapper.AccountMapper;
import com.oscar.accountsmicroservice.mapper.CustomerMapper;
import com.oscar.accountsmicroservice.repository.AccountRepository;
import com.oscar.accountsmicroservice.repository.CustomerRepository;
import com.oscar.accountsmicroservice.service.IAccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = customerRepository.findByMobileNumber(customerDTO.getMobileNumber())
                .orElseThrow(() -> new CustomerAlreadyExistsException("Customer already registered with given mobile number"));
        Customer savedCustomer = customerRepository.save(CustomerMapper.toEntity(customerDTO));
        accountRepository.save(createNewAccount(savedCustomer));
    }

    /**
     *
     * @param customer - Customer Object
     * @return the new account details
     */
    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        return newAccount;
    }

    /**
     *
     * @param mobileNumber - Input mobile number
     * @return Account details based on a given mobile number
     */
    @Override
    public CustomerDTO fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        Account account = accountRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));

        CustomerDTO customerDTO = CustomerMapper.toDTO(customer);
        customerDTO.setAccountDTO(AccountMapper.toDTO(account));

        return customerDTO;
    }

    /**
     *
     * @param customerDTO - CustomerDTO object
     * @return boolean indicating if the update of Account details is successful or not
     */
    @Override
    public boolean updateAccount(CustomerDTO customerDTO) {
        boolean isUpdated = false;
        AccountDTO accountDTO = customerDTO.getAccountDTO();
        if (accountDTO != null) {
            Account account = accountRepository.findById(accountDTO.getAccountNumber())
                    .orElseThrow(() -> new ResourceNotFoundException("Account", "account number", accountDTO.getAccountNumber().toString()));
            account = AccountMapper.toEntity(accountDTO);
            account = accountRepository.save(account);

            Long customerId = account.getCustomerId();
            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId.toString()));
            customer = CustomerMapper.toEntity(customerDTO);
            customerRepository.save(customer);
            isUpdated = true;
        }

        return isUpdated;
    }

    /**
     *
     * @param mobileNumber - Input mobile number
     * @return boolean indicating if the delete of Account details is successful or not
     */
    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobile number", mobileNumber));
        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }

}
