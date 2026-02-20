package com.mahalaxmi_rentals.app.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    private String mobileNumber;

    private String username;

    private String pin;

    private Address address;

    private boolean profileComplete;
}
