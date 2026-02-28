package com.mahalaxmi_rentals.app.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admins")
@Getter
@Setter
public class Admin {

    @Id
    private String id;

    private String username;
    private String password; // (Later we will hash this)
}