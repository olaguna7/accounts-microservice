package com.oscar.accountsmicroservice.controller;

import com.oscar.accountsmicroservice.constants.AccountConstants;
import com.oscar.accountsmicroservice.dto.CustomerDTO;
import com.oscar.accountsmicroservice.dto.ResponseDTO;
import com.oscar.accountsmicroservice.service.IAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountController {

    private final IAccountService accountService;
    private final IAccountService iAccountService;

    public AccountController(IAccountService accountService, IAccountService iAccountService) {
        this.accountService = accountService;
        this.iAccountService = iAccountService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customer) {
        accountService.createAccount(customer);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(@RequestParam String mobileNumber) {
        CustomerDTO customerDTO = accountService.fetchAccount(mobileNumber);
        return ResponseEntity.ok(customerDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAccountDetails(@RequestBody CustomerDTO customerDTO) {
        boolean isUpdated = accountService.updateAccount(customerDTO);
        if (isUpdated) {
            return ResponseEntity.ok(new ResponseDTO(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(AccountConstants.STATUS_500, AccountConstants.MESSAGE_500));
        }
    }

}
