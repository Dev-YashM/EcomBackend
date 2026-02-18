package com.mahalaxmi_rentals.app.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompleteProfileRequest {
    @NotBlank
    private String username;

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

    public @NotBlank String getPinCode() {
        return pinCode;
    }

    public void setPinCode(@NotBlank String pinCode) {
        this.pinCode = pinCode;
    }

    public @NotBlank String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank String username) {
        this.username = username;
    }

    public @NotBlank String getState() {
        return state;
    }

    public void setState(@NotBlank String state) {
        this.state = state;
    }

    public @NotBlank String getLaneArea() {
        return laneArea;
    }

    public void setLaneArea(@NotBlank String laneArea) {
        this.laneArea = laneArea;
    }

    public @NotBlank String getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(@NotBlank String plotNo) {
        this.plotNo = plotNo;
    }

    public @NotBlank String getCity() {
        return city;
    }

    public void setCity(@NotBlank String city) {
        this.city = city;
    }
}
