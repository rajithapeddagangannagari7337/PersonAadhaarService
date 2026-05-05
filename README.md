# 👤 Person–Aadhaar Management System

A Spring Boot based RESTful application to manage **Person** and **Aadhaar** data with a **One-to-One relationship**, supporting full CRUD operations and API testing.

---

## 🚀 Tech Stack

* **Java**
* **Spring Boot**
* **Spring Data JPA (Hibernate)**
* **PostgreSQL**
* **Postman (API Testing)**

---

## 📂 Project Structure

```
com.pa
│
├── controller
│   ├── PersonController.java
│   └── AadhaarController.java
│
├── service
│   ├── PersonService.java
│   └── AadhaarService.java
│
├── repo
│   ├── PersonRepo.java
│   └── AadhaarRepo.java
│
├── entity
│   ├── Person.java
│   └── Aadhaar.java
│
├── exception
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
```

---

## 🧩 Features

* ✅ Full CRUD operations for Person and Aadhaar
* ✅ One-to-One mapping between Person and Aadhaar
* ✅ RESTful API design using proper HTTP methods
* ✅ Validation using annotations (`@NotBlank`, `@Min`, etc.)
* ✅ Global Exception Handling
* ✅ API testing with Postman (positive & negative cases)

---

## 🔗 Entity Relationship

* **Person**

  * pid (Primary Key)
  * name
  * age
  * gender
  * aadhaar (One-to-One)

* **Aadhaar**

  * aid (Primary Key)
  * anum
  * address

---

## 🔄 API Endpoints

### 🟢 Aadhaar APIs

| Method | Endpoint        | Description       |
| ------ | --------------- | ----------------- |
| POST   | `/aadhaar`      | Create Aadhaar    |
| GET    | `/aadhaar`      | Get all Aadhaar   |
| GET    | `/aadhaar/{id}` | Get Aadhaar by ID |
| PUT    | `/aadhaar/{id}` | Update Aadhaar    |
| DELETE | `/aadhaar/{id}` | Delete Aadhaar    |

---

### 🟢 Person APIs

| Method | Endpoint              | Description                |
| ------ | --------------------- | -------------------------- |
| POST   | `/person/{aadhaarId}` | Create Person with Aadhaar |
| GET    | `/person`             | Get all Persons            |
| GET    | `/person/{id}`        | Get Person by ID           |
| PUT    | `/person/{id}`        | Update Person              |
| DELETE | `/person/{id}`        | Delete Person              |

---

## ⚙️ How It Works

1. Create an Aadhaar record
2. Use Aadhaar ID to create a Person
3. The Person is mapped to Aadhaar using One-to-One relationship

---

## 🧪 Sample Request

### Create Aadhaar

```json
{
  "anum": "123456789012",
  "address": "Bangalore"
}
```

### Create Person

```json
{
  "name": "Rahul",
  "age": 25,
  "gender": "Male"
}
```

---

## ❗ Error Handling

* 400 → Bad Request (validation errors)
* 404 → Resource Not Found
* Proper error messages returned using Global Exception Handler

---

## 🛠️ Setup Instructions

1. Clone the repository

```
git clone https://github.com/yourusername/person-aadhaar-springboot.git
```

2. Configure PostgreSQL in `application.properties`

```
spring.datasource.url=jdbc:postgresql://localhost:5432/persondb
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Run the application

4. Test APIs using Postman

---

## 📌 Future Enhancements

* Add DTO layer for better architecture
* Implement Swagger for API documentation
* Add authentication (Spring Security)
* Enforce strict One-to-One constraint

---

## 👨‍💻 Author

Your Name
GitHub: https://github.com/yourusername

---

## ⭐ Conclusion

This project demonstrates backend development skills including REST API design, database integration, entity relationships, validation, and testing.
