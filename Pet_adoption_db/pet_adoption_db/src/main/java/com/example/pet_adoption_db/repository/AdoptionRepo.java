package com.example.pet_adoption_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pet_adoption_db.model.Adoption;

public interface AdoptionRepo extends JpaRepository<Adoption,String>{
    
}
