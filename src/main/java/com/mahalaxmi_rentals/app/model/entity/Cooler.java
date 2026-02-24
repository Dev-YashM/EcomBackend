package com.mahalaxmi_rentals.app.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "coolers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cooler {

    @Id
    private String id;

    private String name;

    private List<String> images;

    private String priceTag;

    private String model;

    private String type;

    private String fanSpeeds;

    private String waterTank;

    private int dailyRent;

    private int monthlyRent;

    private int seasonalRent;
}
