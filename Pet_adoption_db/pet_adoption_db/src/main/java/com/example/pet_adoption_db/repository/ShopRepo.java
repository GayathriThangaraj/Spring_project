package com.example.pet_adoption_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pet_adoption_db.model.Shop;

public interface ShopRepo extends JpaRepository<Shop,String>
{
    @Query("SELECT s FROM Shop s WHERE s.name = :name")
    Shop findPetByName(@RequestParam("name") String name);
    
} 