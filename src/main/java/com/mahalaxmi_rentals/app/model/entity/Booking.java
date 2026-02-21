package com.mahalaxmi_rentals.app.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "bookings")
@Getter
@Setter
public class Booking {

    @Id
    private String id;

    private String mobile;
    private String coolerTitle;
    private String rentalDuration;
    private int price;

    private String orderStatus = "PENDING";   // ✅ default value

    private LocalDateTime bookedAt = LocalDateTime.now();

    // getters & setters
}