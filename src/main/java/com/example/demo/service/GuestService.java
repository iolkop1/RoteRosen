package com.example.demo.service;

import com.example.demo.entity.Guest;
import com.example.demo.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository repository;

    public ResponseEntity<String> saveGuest(Guest guest){
        if(guest.getName() != null)
        {
            repository.save(guest);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully created");
        }
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name cannot be empty");
    }

    public List<Guest> getGuests(){
        return repository.findAll();
    }

    public Guest getGuestById(int id){
        return repository.findById(id).orElse(null);
    }

    public String deleteGuest(int id){
        repository.deleteById(id);
        return "Guest deleted";
    }
}