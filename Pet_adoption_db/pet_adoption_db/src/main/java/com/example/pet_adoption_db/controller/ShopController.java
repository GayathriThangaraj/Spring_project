package com.example.pet_adoption_db.controller;

import java.util.List;

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

import com.example.pet_adoption_db.model.Shop;
import com.example.pet_adoption_db.service.ShopService;

@RestController
public class ShopController 
{
    @Autowired
    ShopService ss;
    
    @PostMapping("/postshop")
    public ResponseEntity<Shop> add( @RequestBody Shop s)
    {
        Shop shops=ss.create(s);
        return new ResponseEntity<>(shops,HttpStatus.CREATED);
    }

    @GetMapping("/getshop")
    public ResponseEntity<java.util.List<Shop>> showLoginDate()
    {
        return new ResponseEntity<>(ss.getall(),HttpStatus.OK);
    }
    
    @GetMapping("/getshop/{name}")
    public ResponseEntity<Shop> show(@PathVariable("name") String name)
    {
        return new ResponseEntity<>(ss.getShopById(name),HttpStatus.OK);
    }

    @PutMapping("/putshop/{name}")
    public ResponseEntity<Shop> putMethodName(@PathVariable("name") String name, @RequestBody Shop s) {
        if(ss.update(name,s) == true)
        {
            return new ResponseEntity<>(s,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/deleteshop/{name}")
    public ResponseEntity<Boolean> delete(@PathVariable("name") String name)
    {
        if(ss.delete(name) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    //sorting controller
    @GetMapping("/api/shop/sortBy/{name}")
    public List<Shop> g(@PathVariable String name)
    {
        return ss.sort(name);
    }

     //pagination
     @GetMapping("/api/page/{offset}/{pagesize}")
     public ResponseEntity <List<Shop>> get(@PathVariable int offset,@PathVariable int pagesize)
     {
         try{
             return new ResponseEntity<>(ss.page(offset,pagesize),HttpStatus.OK);
          }
          catch(Exception e)
          {
              return new ResponseEntity<>(ss.page(offset,pagesize),HttpStatus.NOT_FOUND);
          }
     }


    //sorting and pagination
    @GetMapping("/api/{offset}/{pagesize}/{name}")
    public ResponseEntity<List<Shop>> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String name)
    {
        try{
            return new ResponseEntity<>(ss.getsort(offset,pagesize,name),HttpStatus.OK);
         }
         catch(Exception e)
         {
             return new ResponseEntity<>(ss.getsort(offset,pagesize,name),HttpStatus.NOT_FOUND);
         }
    }

 
    //query controller
    @GetMapping("/query/{name}")
    public ResponseEntity<Shop> findPetByName(@PathVariable String name) 
    {
        Shop sh = ss.findPetByName(name);
        try{
            return new ResponseEntity<>(sh,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(sh,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
    




