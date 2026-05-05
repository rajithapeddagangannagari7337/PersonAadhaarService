package org.example.personaadhaarservice.controller;

import jakarta.validation.Valid;
import org.example.personaadhaarservice.entity.Aadhaar;
import org.example.personaadhaarservice.service.AadhaarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aadhaar")
@Validated
public class AadhaarController {

    @Autowired
    private AadhaarService service;

    // CREATE
    @PostMapping
    public ResponseEntity<Aadhaar> save(@Valid @RequestBody Aadhaar a) {
        Aadhaar saved = service.saveAadhaar(a);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Aadhaar>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Aadhaar> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Aadhaar> update(@PathVariable Long id,
                                          @Valid @RequestBody Aadhaar a) {
        return ResponseEntity.ok(service.update(id, a));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}