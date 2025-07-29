package com.oscar.accountsmicroservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountDTO {

    @NotEmpty(message = "Account number can't be a null or empty")
    @Pattern(regexp = "^$|\\d{10}", message = "Account number must be 10 digits")
    private Long accountNumber;

    @NotEmpty(message = "Account type can't be a null or empty")
    private String accountType;

    @NotEmpty(message = "Branch address can't be a null or empty")
    private String branchAddress;
}
