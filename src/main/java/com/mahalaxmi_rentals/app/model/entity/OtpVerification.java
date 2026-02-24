package com.mahalaxmi_rentals.app.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "otp_verification")
public class OtpVerification {

    @Id
    private String id;

    private String mobileNumber;

    private String otp;

    @Indexed(expireAfterSeconds = 300)
    private LocalDateTime expiryTime;
}
