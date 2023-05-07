package com.example.demo;

import com.example.demo.entity.Guest;
import com.example.demo.repository.GuestRepository;
import com.example.demo.service.GuestService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GuestServiceTest {

    @Mock
    private GuestRepository repository;

    @InjectMocks
    private GuestService service;

    @Test
    void saveGuestWithValidNameReturnsOk() {
        // Arrange
        Guest guest = new Guest();
        guest.setName("John");

        // Mock repository behavior
        when(repository.save(any(Guest.class))).thenReturn(guest);

        // Act
        ResponseEntity<String> response = service.saveGuest(guest);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Successfully created", response.getBody());
    }

    @Test
    void saveGuestWithNullNameReturnsBadRequest() {
        // Arrange
        Guest guest = new Guest();

        // Act
        ResponseEntity<String> response = service.saveGuest(guest);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Name cannot be empty", response.getBody());
    }

    @Test
    void getGuestsReturnsAllGuests() {
        // Arrange
        List<Guest> guests = Arrays.asList(
                new Guest(1, "John", "test", "12"),
                new Guest(2, "Jane","test", "12")
        );

        // Mock repository behavior
        when(repository.findAll()).thenReturn(guests);

        // Act
        List<Guest> result = service.getGuests();

        // Assert
        assertEquals(guests, result);
    }

    @Test
    void getGuestByIdWithExistingIdReturnsGuest() {
        // Arrange
        int id = 1;
        Guest guest = new Guest(id, "John","test", "12");

        // Mock repository behavior
        when(repository.findById(id)).thenReturn(Optional.of(guest));

        // Act
        Guest result = service.getGuestById(id);

        // Assert
        assertEquals(guest, result);
    }

    @Test
    void getGuestByIdWithNonExistingIdReturnsNull() {
        // Arrange
        int id = 1;

        // Mock repository behavior
        when(repository.findById(id)).thenReturn(Optional.empty());

        // Act
        Guest result = service.getGuestById(id);

        // Assert
        assertNull(result);
    }

    @Test
    void deleteGuestWithExistingIdReturnsSuccessMessage() {
        // Arrange
        int id = 1;

        // Act
        String result = service.deleteGuest(id);

        // Assert
        assertEquals("Guest deleted", result);
        verify(repository, times(1)).deleteById(id);
    }
}