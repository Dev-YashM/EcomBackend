package com.mahalaxmi_rentals.app.controller;

import com.mahalaxmi_rentals.app.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create-order/{bookingId}")
    public ResponseEntity<?> createOrder(@PathVariable String bookingId) throws Exception {
        return ResponseEntity.ok(paymentService.createRazorpayOrder(bookingId));
    }

    @PostMapping("/verify/{bookingId}")
    public ResponseEntity<?> verifyPayment(
            @PathVariable String bookingId,
            @RequestParam String paymentId,
            @RequestParam String signature) throws Exception {

        return ResponseEntity.ok(
                paymentService.verifyPayment(bookingId, paymentId, signature)
        );
    }
}