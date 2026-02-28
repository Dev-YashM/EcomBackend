package com.mahalaxmi_rentals.app.controller;

import com.mahalaxmi_rentals.app.model.dto.BookingRequest;
import com.mahalaxmi_rentals.app.model.dto.UpdateStatusRequest;
import com.mahalaxmi_rentals.app.model.entity.Booking;
import com.mahalaxmi_rentals.app.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<?> createBooking(
            @Valid @RequestBody BookingRequest request) {

        return ResponseEntity.ok(bookingService.createBooking(request));
    }

    @GetMapping("/user/{mobile}")
    public ResponseEntity<?> getUserBookings(@PathVariable String mobile) {
        return ResponseEntity.ok(bookingService.getBookingsByMobile(mobile));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @PutMapping("/update-status/{bookingId}")
    public ResponseEntity<Booking> updateOrderStatus(
            @PathVariable String bookingId,
            @RequestBody UpdateStatusRequest request) {

        return ResponseEntity.ok(
                bookingService.updateOrderStatus(bookingId, request.getOrderStatus())
        );
    }
}