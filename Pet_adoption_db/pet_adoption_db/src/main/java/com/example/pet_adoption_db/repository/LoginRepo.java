package com.example.pet_adoption_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pet_adoption_db.model.login;

public interface LoginRepo extends JpaRepository<login,String>{

    
}
