package com.mahalaxmi_rentals.app.service;

import com.mahalaxmi_rentals.app.model.entity.Cooler;
import com.mahalaxmi_rentals.app.repository.CoolerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoolerService {

    private final CoolerRepository coolerRepository;

    public List<Cooler> getAllCoolers() {
        return coolerRepository.findAll();
    }

    public Cooler getCoolerById(String id) {
        return coolerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cooler not found"));
    }

    public Cooler saveCooler(Cooler cooler) {
        return coolerRepository.save(cooler);
    }
}
