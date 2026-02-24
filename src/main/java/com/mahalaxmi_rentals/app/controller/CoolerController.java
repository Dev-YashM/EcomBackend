package com.mahalaxmi_rentals.app.controller;

import com.mahalaxmi_rentals.app.model.entity.Cooler;
import com.mahalaxmi_rentals.app.service.CoolerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coolers")
@RequiredArgsConstructor
public class CoolerController {

    private final CoolerService coolerService;

    @GetMapping
    public ResponseEntity<List<Cooler>> getAllCoolers() {
        return ResponseEntity.ok(coolerService.getAllCoolers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cooler> getCoolerById(@PathVariable String id) {
        return ResponseEntity.ok(coolerService.getCoolerById(id));
    }

    @PostMapping
    public ResponseEntity<Cooler> addCooler(@RequestBody Cooler cooler) {
        return ResponseEntity.ok(coolerService.saveCooler(cooler));
    }
}
