package com.example.pet_adoption_db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pet_adoption_db.model.Adoption;
import com.example.pet_adoption_db.service.AdoptionService;

@RestController
public class AdoptionController {
    @Autowired
    AdoptionService as;

    @PostMapping("/postadopt")
    public ResponseEntity<Adoption> add( @RequestBody Adoption a)
    {
        Adoption aa=as.create(a);
        return new ResponseEntity<>(aa,HttpStatus.CREATED);
    }

    @GetMapping("/getadopt")
    public ResponseEntity<java.util.List<Adoption>> showLoginDate()
    {
        return new ResponseEntity<>(as.get(),HttpStatus.OK);
    }
    @GetMapping("/getadopt/{animal}")
    public ResponseEntity<Adoption> showLDate(@PathVariable("animal") String animal)
    {
        return new ResponseEntity<>(as.getId(animal),HttpStatus.OK);
    }

    @PutMapping("/putadopt/{animal}")
    public ResponseEntity<Adoption> putMethodName(@PathVariable("animal") String animal, @RequestBody Adoption a) {
        if(as.update(animal,a) == true)
        {
            return new ResponseEntity<>(a,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/deleteadopt/{animal}")
    public ResponseEntity<Boolean> delete(@PathVariable("animal") String animal)
    {
        if(as.delete(animal) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    
}
