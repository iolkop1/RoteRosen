package com.example.demo.service;

import com.example.demo.entity.Reservation;
import com.example.demo.repository.GuestRepository;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class ReservationService {
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    public ResponseEntity<String> saveReservation(Reservation reservation){

        if(guestRepository.findById(reservation.getGuestId()).isPresent())
        {
            reservationRepository.save(reservation);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully created");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Guest does not exist");
    }


}
