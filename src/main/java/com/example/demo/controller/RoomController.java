package com.example.demo.controller;

import com.example.demo.entity.Room;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {

    @Autowired
    private RoomService service;

    @PostMapping("/addRoom")
    public Room addRoom(@RequestBody Room room){
        return service.saveRoom(room);
    }

    @GetMapping("/findRoomById/{id}")
    public Room getRoomById(@PathVariable int id){
        return service.getRoomById(id);
    }

    @PutMapping("/update")
    public Room updateRoom(@RequestBody Room room) {
        return service.updateRoom(room);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRoom(@PathVariable int id){
        return service.deleteRoom(id);
    }
}
