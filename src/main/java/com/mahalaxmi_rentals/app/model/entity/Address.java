package com.mahalaxmi_rentals.app.model.entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    private String plotNo;
    private String laneArea;
    private String city;
    private String state;
    private String pinCode;
}
