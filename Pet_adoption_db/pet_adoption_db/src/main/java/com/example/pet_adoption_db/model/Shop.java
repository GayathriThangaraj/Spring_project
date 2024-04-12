package com.example.pet_adoption_db.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Shops")
public class Shop {
    @Id
    String name;
    String animal,breed,location,sex;
    int age;

    @OneToOne(mappedBy = "shop",cascade = CascadeType.ALL)
    @JoinColumn(name="fk_add_id")
    @JsonManagedReference
    Adoption adoption;//obj of secondary table

    public Adoption getAdoption() {
        return adoption;
    }
    public void setAdoption(Adoption adoption) {
        this.adoption = adoption;
    }
    public Shop() {
    }
    public Shop(String name, String animal, String breed, String location, String sex, int age) {
        this.name = name;
        this.animal = animal;
        this.breed = breed;
        this.location = location;
        this.sex = sex;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAnimal() {
        return animal;
    }
    public void setAnimal(String animal) {
        this.animal = animal;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }



    
}
