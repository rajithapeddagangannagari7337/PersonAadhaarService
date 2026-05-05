package org.example.personaadhaarservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 1, message = "Age must be positive")
    private int age;

    @NotBlank(message = "Gender is required")
    private String gender;

    @OneToOne
    @JoinColumn(name = "aadhaar_id")
    private Aadhaar aadhaar;
}
