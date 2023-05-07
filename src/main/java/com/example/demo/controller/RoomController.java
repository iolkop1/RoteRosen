package com.example.demo.controller;

import com.example.demo.entity.Room;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {

    @Autowired
    private RoomService service;

    /**
     * Add new room with description and price per night
     * @param room
     * @return
     */
    @PostMapping("/addRoom")
    public Room addRoom(@RequestBody Room room){
        return service.saveRoom(room);
    }

    /**
     * Retrieve a certain room by its id
     * @param id
     * @return
     */
    @GetMapping("/findRoomById/{id}")
    public Room getRoomById(@PathVariable int id){
        return service.getRoomById(id);
    }

    /**
     * Update a specific room's description
     * @param room
     * @return
     */
    @PutMapping("/update")
    public Room updateRoom(@RequestBody Room room) {
        return service.updateRoom(room);
    }

    /**
     * Delete a room by its id
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public String deleteRoom(@PathVariable int id){
        return service.deleteRoom(id);
    }
}
