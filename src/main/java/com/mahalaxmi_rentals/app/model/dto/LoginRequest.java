package com.mahalaxmi_rentals.app.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginRequest {

    private String mobileNumber;
    private String pin;

}