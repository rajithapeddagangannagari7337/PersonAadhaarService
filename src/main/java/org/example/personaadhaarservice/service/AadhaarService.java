package org.example.personaadhaarservice.service;

import org.example.personaadhaarservice.entity.Aadhaar;
import org.example.personaadhaarservice.exception.ResourceNotFoundException;
import org.example.personaadhaarservice.repo.AadhaarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AadhaarService {

    @Autowired
    private AadhaarRepo repo;

    // CREATE
    public Aadhaar saveAadhaar(Aadhaar a) {
        return repo.save(a);
    }

    // READ ALL
    public List<Aadhaar> getAll() {
        return repo.findAll();
    }

    // READ BY ID
    public Aadhaar getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aadhaar not found with id: " + id));
    }

    // UPDATE
    public Aadhaar update(Long id, Aadhaar a) {
        Aadhaar existing = getById(id);

        existing.setAnum(a.getAnum());
        existing.setAddress(a.getAddress());

        return repo.save(existing);
    }

    // DELETE
    public String delete(Long id) {
        Aadhaar existing = getById(id);
        repo.delete(existing);
        return "Aadhaar deleted successfully";
    }
}
