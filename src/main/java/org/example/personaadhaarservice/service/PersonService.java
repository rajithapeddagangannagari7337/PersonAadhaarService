package org.example.personaadhaarservice.service;

import org.example.personaadhaarservice.entity.Aadhaar;
import org.example.personaadhaarservice.entity.Person;
import org.example.personaadhaarservice.exception.ResourceNotFoundException;
import org.example.personaadhaarservice.repo.AadhaarRepo;
import org.example.personaadhaarservice.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private AadhaarRepo aadhaarRepo;

    // CREATE (with Aadhaar ID)
    public Person savePerson(Person p, Long aadhaarId) {

        Aadhaar aadhaar = aadhaarRepo.findById(aadhaarId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Aadhaar not found with id: " + aadhaarId));

        p.setAadhaar(aadhaar);

        return personRepo.save(p);
    }

    // READ ALL
    public List<Person> getAll() {
        return personRepo.findAll();
    }

    // READ BY ID
    public Person getById(Long id) {
        return personRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Person not found with id: " + id));
    }

    // UPDATE
    public Person update(Long id, Person p) {
        Person existing = getById(id);

        existing.setName(p.getName());
        existing.setAge(p.getAge());
        existing.setGender(p.getGender());

        return personRepo.save(existing);
    }

    // DELETE
    public String delete(Long id) {
        Person existing = getById(id);
        personRepo.delete(existing);
        return "Person deleted successfully";
    }
}