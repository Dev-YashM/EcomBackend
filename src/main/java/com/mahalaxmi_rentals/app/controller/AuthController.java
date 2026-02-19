package com.mahalaxmi_rentals.app.controller;

import com.mahalaxmi_rentals.app.model.dto.CompleteProfileRequest;
import com.mahalaxmi_rentals.app.model.dto.SendOtpRequest;
import com.mahalaxmi_rentals.app.model.dto.VerifyOtpRequest;
import com.mahalaxmi_rentals.app.model.entity.User;
import com.mahalaxmi_rentals.app.service.OtpService;
import com.mahalaxmi_rentals.app.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final OtpService otpService;
    private final UserService userService;

    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOtp(@RequestBody SendOtpRequest request) {

        otpService.sendOtp(request.getMobileNumber());

        return ResponseEntity.ok("OTP sent successfully");
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody VerifyOtpRequest request) {

        boolean isValid = otpService.verifyOtp(
                request.getMobileNumber(),
                request.getOtp()
        );

        if (!isValid) {
            return ResponseEntity.badRequest().body("Invalid OTP");
        }

        User user = userService.createUserIfNotExists(request.getMobileNumber());

        Map<String, Object> response = new HashMap<>();
        response.put("mobileNumber", user.getMobileNumber());
        response.put("profileComplete", user.isProfileComplete());

        return ResponseEntity.ok(response);
    }
    @PostMapping("/complete-profile/")
    public ResponseEntity<?> completeProfile(
            @PathVariable String mobileNumber,
            @Valid @RequestBody CompleteProfileRequest request) {

    User user = userService.completeProfile(mobileNumber, request);

    return ResponseEntity.ok(user);
}
}
