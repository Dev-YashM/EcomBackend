package com.mahalaxmi_rentals.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String isAlive() {
        return "Is Alive";
    }
}