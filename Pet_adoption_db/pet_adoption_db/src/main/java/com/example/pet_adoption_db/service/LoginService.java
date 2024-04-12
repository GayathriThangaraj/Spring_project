package com.example.pet_adoption_db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pet_adoption_db.model.login;
import com.example.pet_adoption_db.repository.LoginRepo;

@Service
public class LoginService {
    @Autowired
    LoginRepo lr;
    
    public login create(login l)
    {
        return lr.save(l);
    }
    public List<login> getall()
    {
        return lr.findAll();
    }
    public login getloginById(String username) 
    {
        return lr.findById(username).orElse(null);
    }
    public boolean update(String username,login l)
    {
        if(this.getloginById(username)==null)
        {
            return false;
        }
        try{
            lr.save(l);
        }
        catch(Exception e)
        {
            return false;
        }
        return  true;
    }
    public boolean delete(String username)
    {
        if(this.getloginById(username)==null)
        {
            return false;
        }
        lr.deleteById(username);
        return true;
    }
    
}
