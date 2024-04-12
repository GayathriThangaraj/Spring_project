package com.example.pet_adoption_db.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Adoption {
    @Id
    String animal;
    String vetname;
    String contact;
    String acctype;
    String feedback;

    @OneToOne
    @JsonBackReference
    Shop shop;


    public Adoption() {
    }
    public Adoption(String animal, String vetname, String contact, String acctype, String feedback) {
        this.animal = animal;
        this.vetname = vetname;
        this.contact = contact;
        this.acctype = acctype;
        this.feedback = feedback;
    }
    public String getAnimal() {
        return animal;
    }
    public void setAnimal(String animal) {
        this.animal = animal;
    }
    public String getVetname() {
        return vetname;
    }
    public void setVetname(String vetname) {
        this.vetname = vetname;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getAcctype() {
        return acctype;
    }
    public void setAcctype(String acctype) {
        this.acctype = acctype;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    

    
}
