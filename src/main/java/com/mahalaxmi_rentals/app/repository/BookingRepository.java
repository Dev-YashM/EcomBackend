package com.mahalaxmi_rentals.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mahalaxmi_rentals.app.model.entity.Booking;

import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {

    List<Booking> findByMobile(String mobile);
}