package com.mahalaxmi_rentals.app.repository;

import com.mahalaxmi_rentals.app.model.entity.OtpVerification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OtpRepository extends MongoRepository<OtpVerification, String> {

    Optional<OtpVerification> findByMobileNumber(String mobileNumber);

    void deleteByMobileNumber(String mobileNumber);
}
