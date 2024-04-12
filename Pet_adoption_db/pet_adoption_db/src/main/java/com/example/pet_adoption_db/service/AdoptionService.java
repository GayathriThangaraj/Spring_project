package com.example.pet_adoption_db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pet_adoption_db.model.Adoption;
import com.example.pet_adoption_db.repository.AdoptionRepo;

@Service
public class AdoptionService {
    @Autowired
    AdoptionRepo ar;

    public Adoption create(Adoption a)
    {
        return ar.save(a);
    }

    public List<Adoption> get()
    {
        return ar.findAll();
    }

    public Adoption getId(String animal)
    {
        return ar.findById(animal).orElse(null);
    }

    public boolean update(String animal,Adoption a)
    {
        if(this.getId(animal)==null)
        {
            return false;
        }
        try{
            ar.save(a);
        }
        catch(Exception e)
        {
            return false;
        }
        return  true;
    }
    public boolean delete(String animal)
    {
        if(this.getId(animal)==null)
        {
            return false;
        }
        ar.deleteById(animal);
        return true;
    }
    
}
