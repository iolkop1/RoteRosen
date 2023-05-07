package com.example.demo.service;

import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    public Reservation saveReservation(Reservation reservation){
        return repository.save(reservation);
    }

}
