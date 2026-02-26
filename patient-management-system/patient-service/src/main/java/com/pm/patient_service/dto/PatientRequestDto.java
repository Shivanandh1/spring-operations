package com.pm.patient_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class PatientRequestDto {

    @NotBlank
    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    @NotBlank
    @Size(max = 100, message = "Email must be less than 100 characters")
    private String email;

    @NotBlank
    @Size(max = 200, message = "Address is required")
    private String address;

    @NotBlank(message = "Date of Birth is required")
    private String dateOfBirth;

    @NotBlank(message = "Registered Date is required")
    private String registeredDate;

}
