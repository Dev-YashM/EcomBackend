package com.mahalaxmi_rentals.app.service;

import com.mahalaxmi_rentals.app.model.entity.Booking;
import com.mahalaxmi_rentals.app.repository.BookingRepository;
import com.razorpay.*;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Value("${razorpay.key-secret}")
    private String keySecret;

    private final RazorpayClient razorpayClient;
    private final BookingRepository bookingRepository;

    public Booking createRazorpayOrder(String bookingId) throws Exception {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        JSONObject options = new JSONObject();
        options.put("amount", booking.getPrice() * 100);
        options.put("currency", "INR");
        options.put("receipt", bookingId);

        Order order = razorpayClient.orders.create(options);

        booking.setRazorpayOrderId(order.get("id"));
        booking.setPaymentStatus("CREATED");

        return bookingRepository.save(booking);
    }

    public Booking verifyPayment(
            String bookingId,
            String paymentId,
            String signature) throws Exception {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        JSONObject options = new JSONObject();
        options.put("razorpay_order_id", booking.getRazorpayOrderId());
        options.put("razorpay_payment_id", paymentId);
        options.put("razorpay_signature", signature);

        boolean isValid = Utils.verifyPaymentSignature(options, keySecret);

        if (!isValid) {
            booking.setPaymentStatus("FAILED");
            return bookingRepository.save(booking);
        }

        booking.setRazorpayPaymentId(paymentId);
        booking.setRazorpaySignature(signature);
        booking.setPaymentStatus("SUCCESS");
        booking.setOrderStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }
}