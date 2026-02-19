package com.mahalaxmi_rentals.app.repository;

import com.mahalaxmi_rentals.app.model.entity.Cooler;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoolerRepository extends MongoRepository<Cooler, String> {
}
