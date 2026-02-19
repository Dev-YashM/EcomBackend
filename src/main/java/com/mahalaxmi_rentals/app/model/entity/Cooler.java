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

    private String priceTag;   // "Starting At Just ₹599/Month"

    private String model;      // Semi exhaust

    private String type;       // Dessert Cooler

    private String fanSpeeds;  // Low/Medium/High

    private String waterTank;  // 12L

    private int dailyRent;

    private int monthlyRent;

    private int seasonalRent;
}
