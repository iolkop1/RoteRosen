package com.example.demo.controller;

import com.example.demo.entity.Guest;
import com.example.demo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GuestController {

    @Autowired
    private GuestService service;

    /**
     * Add new guest with name and email
     * @param guest
     * @return
     */
    @PostMapping("/addGuest")
    public ResponseEntity<String> addGuest(@RequestBody Guest guest){
        return service.saveGuest(guest);
    }

    /**
     * Retrieve a certain guest by their id
     * @param id
     * @return
     */
    @GetMapping("/findGuestById/{id}")
    public Guest getGuestById(@PathVariable int id){
        return service.getGuestById(id);
    }

    /**
     * Delete a guest by their id
     * @param id
     * @return
     */
    @DeleteMapping("/deleteGuest/{id}")
    public String deleteGuest(@PathVariable int id){
        return service.deleteGuest(id);
    }
}