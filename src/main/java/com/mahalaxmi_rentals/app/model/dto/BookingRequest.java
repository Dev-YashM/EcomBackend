package com.mahalaxmi_rentals.app.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {

    @NotBlank
    private String mobile;

    @NotBlank
    private String coolerTitle;

    @NotBlank
    private String rentalDuration;

    @NotNull
    private Integer price;

}