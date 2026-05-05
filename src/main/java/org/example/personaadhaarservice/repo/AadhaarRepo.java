package org.example.personaadhaarservice.repo;

import org.example.personaadhaarservice.entity.Aadhaar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AadhaarRepo extends JpaRepository<Aadhaar,Long> {

}

