package com.mahalaxmi_rentals.app.service;

import com.mahalaxmi_rentals.app.model.entity.OtpVerification;
import com.mahalaxmi_rentals.app.repository.OtpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OtpService {

    private final OtpRepository otpRepository;

    public void sendOtp(String mobileNumber) {

        String otp = String.valueOf(new Random().nextInt(900000) + 100000);

        otpRepository.deleteByMobileNumber(mobileNumber);

        OtpVerification otpVerification = OtpVerification.builder()
                .mobileNumber(mobileNumber)
                .otp(otp)
                .expiryTime(LocalDateTime.now().plusMinutes(5))
                .build();

        otpRepository.save(otpVerification);

        System.out.println("OTP for " + mobileNumber + " is: " + otp);
    }

    public boolean verifyOtp(String mobileNumber, String otp) {

        return otpRepository.findByMobileNumber(mobileNumber)
                .map(storedOtp -> storedOtp.getOtp().equals(otp))
                .orElse(false);
    }
}
