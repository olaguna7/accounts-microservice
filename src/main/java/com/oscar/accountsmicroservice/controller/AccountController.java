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

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customer) {
        accountService.createAccount(customer);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

}
