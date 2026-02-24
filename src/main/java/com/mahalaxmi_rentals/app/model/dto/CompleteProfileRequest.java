package com.mahalaxmi_rentals.app.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CompleteProfileRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String pin;

    @NotBlank
    private String plotNo;

    @NotBlank
    private String laneArea;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String pinCode;
}
