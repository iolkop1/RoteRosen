package com.example.demo.service;

import com.example.demo.entity.Room;
import com.example.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository repository;

    public Room saveRoom(Room room){
        return repository.save(room);
    }

    public List<Room> getRooms(){
        return repository.findAll();
    }

    public Room getRoomById(int id){
        return repository.findById(id).orElse(null);
    }

    public Room updateRoom(Room room){
        Room existingRoom = repository.findById(room.getId()).orElse(null);
        existingRoom.setDescription(room.getDescription());
        return repository.save(existingRoom);
    }

    public String deleteRoom(int id){
        repository.deleteById(id);
        return "Room deleted";
    }
}
