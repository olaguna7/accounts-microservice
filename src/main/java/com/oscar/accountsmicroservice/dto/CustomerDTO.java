package com.oscar.accountsmicroservice.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerDTO {

    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Email(message = "Email should have a valid format")
    @NotEmpty(message = "Email address can not be a null or empty")
    private String email;

    @Pattern(regexp = "^$|\\d{10}", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    private AccountDTO accountDTO;
}
