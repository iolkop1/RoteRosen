package com.example.demo.service;

import com.example.demo.entity.Guest;
import com.example.demo.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository repository;

    public Guest saveGuest(Guest guest){
        return repository.save(guest);
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