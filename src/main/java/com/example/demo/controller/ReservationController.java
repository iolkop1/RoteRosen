package com.example.demo.controller;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.Room;
import com.example.demo.service.ReservationService;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService service;

    /**
     * Add new reservation
     * @param reservation
     * @return
     */
    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return service.saveReservation(reservation);
    }
}
