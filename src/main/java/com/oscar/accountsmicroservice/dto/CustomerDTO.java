package com.oscar.accountsmicroservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(name = "Customer", description = "Schema to hold Customer and Account information")
public class CustomerDTO {

    @Schema(description = "Name of the customer", example = "John Doe")
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(description = "Email of the customer", example = "example@example.com")
    @Email(message = "Email should have a valid format")
    @NotEmpty(message = "Email address can not be a null or empty")
    private String email;

    @Schema(description = "Mobile number of the customer", example = "1234567890")
    @Pattern(regexp = "^$|\\d{10}", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(description = "Account details of the Customer")
    private AccountDTO accountDTO;
}
