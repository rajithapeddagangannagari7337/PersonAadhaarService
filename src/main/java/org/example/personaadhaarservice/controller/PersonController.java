package org.example.personaadhaarservice.controller;

import jakarta.validation.Valid;
import org.example.personaadhaarservice.entity.Person;
import org.example.personaadhaarservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@Validated
public class PersonController {

    @Autowired
    private PersonService service;

    // CREATE with Aadhaar ID
    @PostMapping("/{aadhaarId}")
    public ResponseEntity<Person> save(@Valid @RequestBody Person p,
                                       @PathVariable Long aadhaarId) {
        Person saved = service.savePerson(p, aadhaarId);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id,
                                         @Valid @RequestBody Person p) {
        return ResponseEntity.ok(service.update(id, p));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}