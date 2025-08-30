package com.zentra.api.controller;

import com.zentra.api.entity.Settings;
import com.zentra.api.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/settings")
@CrossOrigin(origins = "*")
public class SettingsController {
    
    @Autowired
    private SettingsRepository settingsRepository;
    
    @GetMapping
    public List<Settings> getAllSettings() {
        return settingsRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Settings> getSettingsById(@PathVariable Long id) {
        return settingsRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Settings createSettings(@RequestBody Settings settings) {
        return settingsRepository.save(settings);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Settings> updateSettings(@PathVariable Long id, @RequestBody Settings settings) {
        return settingsRepository.findById(id)
                .map(existingSettings -> {
                    settings.setId(id);
                    return ResponseEntity.ok(settingsRepository.save(settings));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}