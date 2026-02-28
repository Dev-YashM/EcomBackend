package com.mahalaxmi_rentals.app.service;

import com.mahalaxmi_rentals.app.model.dto.AdminLoginRequest;
import com.mahalaxmi_rentals.app.model.entity.Admin;
import com.mahalaxmi_rentals.app.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public String login(AdminLoginRequest request) {

        Admin admin = adminRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid Username"));

        if (!admin.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        return "Login Successful";
    }
}