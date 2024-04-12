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

import com.example.pet_adoption_db.model.login;
import com.example.pet_adoption_db.service.LoginService;

@RestController
public class LoginController {
    
    @Autowired
    LoginService ls;

    @PostMapping("/postdata")
    public ResponseEntity<login> add( @RequestBody login l)
    {
        login log=ls.create(l);
        return new ResponseEntity<>(log,HttpStatus.CREATED);
    }

    @GetMapping("/getdata")
    public ResponseEntity<java.util.List<login>> showLoginDate()
    {
        return new ResponseEntity<>(ls.getall(),HttpStatus.OK);
    }

    @PutMapping("/putdata/{username}")
    public ResponseEntity<login> putMethodName(@PathVariable("username") String username, @RequestBody login l) {
        if(ls.update(username,l) == true)
        {
            return new ResponseEntity<>(l,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/delete/{username}")
    public ResponseEntity<Boolean> delete(@PathVariable("username") String username)
    {
        if(ls.delete(username) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
