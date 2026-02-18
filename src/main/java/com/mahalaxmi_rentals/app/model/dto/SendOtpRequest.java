package com.mahalaxmi_rentals.app.model.dto;

import lombok.Data;

@Data
public class SendOtpRequest {
    private String mobileNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
