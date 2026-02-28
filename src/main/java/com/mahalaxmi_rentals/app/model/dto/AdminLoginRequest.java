package com.mahalaxmi_rentals.app.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminLoginRequest {

    private String username;
    private String password;
}