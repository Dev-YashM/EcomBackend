package com.mahalaxmi_rentals.app.service;

import com.mahalaxmi_rentals.app.model.dto.CompleteProfileRequest;
import com.mahalaxmi_rentals.app.model.entity.Address;
import com.mahalaxmi_rentals.app.model.entity.User;
import com.mahalaxmi_rentals.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUserIfNotExists(String mobileNumber) {

        return userRepository.findByMobileNumber(mobileNumber)
                .orElseGet(() -> {
                    User user = User.builder()
                            .mobileNumber(mobileNumber)
                            .profileComplete(false)
                            .build();

                    return userRepository.save(user);
                });
    }

//    public User completeProfile(CompleteProfileRequest request) {
//
//        User user = userRepository.findByMobileNumber(request.getMobileNumber())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Address address = Address.builder()
//                .plotNo(request.getPlotNo())
//                .laneArea(request.getLaneArea())
//                .city(request.getCity())
//                .state(request.getState())
//                .pinCode(request.getPinCode())
//                .build();
//
//        user.setUsername(request.getUsername());
//        user.setAddress(address);
//        user.setProfileComplete(true);
//
//        return userRepository.save(user);
//    }
public User completeProfile(String mobileNumber, CompleteProfileRequest request) {

    User user = userRepository.findByMobileNumber(mobileNumber)
            .orElseThrow(() -> new RuntimeException("User not found"));

    Address address = Address.builder()
            .plotNo(request.getPlotNo())
            .laneArea(request.getLaneArea())
            .city(request.getCity())
            .state(request.getState())
            .pinCode(request.getPinCode())
            .build();

    user.setUsername(request.getUsername());
    user.setAddress(address);
    user.setProfileComplete(true);

    return userRepository.save(user);
}

    public User getUserByProfileId(String mobileNumber) {
        return userRepository.findByMobileNumber(mobileNumber).orElse(null);
    }

}
