package com.example.demo;

import com.example.demo.entity.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {

    @Mock
    private RoomRepository repository;

    @InjectMocks
    private RoomService service;

    @Test
    public void testSaveRoom() {
        // Arrange
        Room room = new Room();
        room.setId(1);
        room.setDescription("Test Room");

        when(repository.save(room)).thenReturn(room);

        // Act
        Room result = service.saveRoom(room);

        // Assert
        assertEquals(room, result);
        verify(repository, times(1)).save(room);
    }

    @Test
    public void testGetRooms() {
        // Arrange
        List<Room> rooms = new ArrayList<>();
        Room room1 = new Room();
        room1.setId(1);
        room1.setDescription("Test Room 1");
        Room room2 = new Room();
        room2.setId(2);
        room2.setDescription("Test Room 2");
        rooms.add(room1);
        rooms.add(room2);

        when(repository.findAll()).thenReturn(rooms);

        // Act
        List<Room> result = service.getRooms();

        // Assert
        assertEquals(rooms, result);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testGetRoomById() {
        // Arrange
        Room room = new Room();
        room.setId(1);
        room.setDescription("Test Room");

        when(repository.findById(1)).thenReturn(Optional.of(room));

        // Act
        Room result = service.getRoomById(1);

        // Assert
        assertEquals(room, result);
        verify(repository, times(1)).findById(1);
    }

    @Test
    public void testUpdateRoom() {
        // Arrange
        Room existingRoom = new Room();
        existingRoom.setId(1);
        existingRoom.setDescription("Test Room");

        Room updatedRoom = new Room();
        updatedRoom.setId(1);
        updatedRoom.setDescription("Updated Test Room");

        when(repository.findById(anyInt())).thenReturn(Optional.of(existingRoom));
        when(repository.save(existingRoom)).thenReturn(existingRoom);

        // Act
        Room result = service.updateRoom(updatedRoom);

        // Assert
        assertEquals(updatedRoom.getDescription(), result.getDescription());
        verify(repository, times(1)).findById(1);
        verify(repository, times(1)).save(existingRoom);
    }

    @Test
    public void testDeleteRoom() {
        // Arrange
        int roomId = 1;

        // Act
        String result = service.deleteRoom(roomId);

        // Assert
        assertEquals("Room deleted", result);
        verify(repository, times(1)).deleteById(roomId);
    }
}