package com.mahalaxmi_rentals.app.service;

import com.mahalaxmi_rentals.app.model.dto.BookingRequest;
import com.mahalaxmi_rentals.app.model.entity.Booking;
import com.mahalaxmi_rentals.app.repository.BookingRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public Booking createBooking(BookingRequest request) {

        Booking booking = new Booking();
        booking.setMobile(request.getMobile());
        booking.setCoolerTitle(request.getCoolerTitle());
        booking.setRentalDuration(request.getRentalDuration());
        booking.setPrice(request.getPrice());

        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByMobile(String mobile) {
        return bookingRepository.findByMobile(mobile);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}