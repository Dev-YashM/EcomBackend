package com.mahalaxmi_rentals.app.controller;

import com.mahalaxmi_rentals.app.model.entity.User;
import com.mahalaxmi_rentals.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile/{mobileNumber}")
    public ResponseEntity<?> getUserProfile(@PathVariable String mobileNumber) {

        User user = userService.getUserByProfileId(mobileNumber);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found");
        }

        return ResponseEntity.ok(user);
    }
}