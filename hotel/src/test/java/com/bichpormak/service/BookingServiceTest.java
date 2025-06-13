package com.bichpormak.service;

import com.bichpormak.model.Room;
import com.bichpormak.repository.RoomRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private BookingService bookingService;

    private static Room room;

    @BeforeAll
    public static void setUp() {

        room = new Room(1, "4 местная", 5000);

    }


    @Test
    @DisplayName("Проверка метода isRoomAvailable")
    void givenRoomAndCheckInDate_whenCheckAvailable_thenReturnTrue() {

        when(roomRepository.findDatesByRoomId(room.id())).
                thenReturn(Optional.of(new ArrayList<>(List.of(LocalDate.of(2025, 6, 13), LocalDate.of(2025, 12, 10)))));

        assertAll(
                () -> assertTrue(bookingService.isRoomAvailable(room, LocalDate.of(2026, 12, 10), LocalDate.of(2027, 12, 10))),
                () -> assertTrue(bookingService.isRoomAvailable(room, LocalDate.of(2024, 12, 10), LocalDate.of(2025, 1, 10)))
        );

    }

    @Test
    @DisplayName("Проверка метода isRoomAvailable")
    void givenRoomAndCheckInDate_whenCheckAvailable_thenReturnFalse() {

        when(roomRepository.findDatesByRoomId(room.id())).
                thenReturn(Optional.of(new ArrayList<>(List.of(LocalDate.of(2025, 6, 13), LocalDate.of(2025, 12, 10)))));

        assertFalse(bookingService.isRoomAvailable(room, LocalDate.of(2025, 6, 11), LocalDate.of(2025, 8, 11)));

    }

    @Test
    @DisplayName("Проверка функциональности bookRoom")
    void givenRoomAndCheckDates_whenBook_thenReturnTrue() {

        when(roomRepository.findDatesByRoomId(room.id())).
                thenReturn(Optional.of(new ArrayList<>(List.of(LocalDate.of(2025, 6, 13), LocalDate.of(2025, 12, 10)))));

        assertTrue(bookingService.bookRoom(room, LocalDate.of(2026, 12, 10), LocalDate.of(2027, 12, 10)));

        verify(roomRepository).saveNewReservation(room.id(), new ArrayList<>(List.of(LocalDate.of(2026, 12, 10), LocalDate.of(2027, 12, 10))));

    }

    @Test
    @DisplayName("Проверка функциональности bookRoom")
    void givenRoomAndCheckDates_whenBook_thenReturnFalse() {

        when(roomRepository.findDatesByRoomId(room.id())).
                thenReturn(Optional.of(new ArrayList<>(List.of(LocalDate.of(2025, 6, 13), LocalDate.of(2025, 12, 10)))));

        assertFalse(bookingService.bookRoom(room, LocalDate.of(2025, 5, 10), LocalDate.of(2027, 12, 10)));

        verify(roomRepository, times(0)).saveNewReservation(room.id(), new ArrayList<>(List.of(LocalDate.of(2026, 12, 10), LocalDate.of(2027, 12, 10))));

    }

    @Test
    @DisplayName("Проверка функциональности calculatePrice")
    void givenRoomAndCheckDates_whenCalculateSum_thenReturnSum() {

        double priceForFourDays = 4 * room.pricePerNight();

        assertEquals(4 * 5000, bookingService.calculatePrice(room, LocalDate.of(2025, 6,13), LocalDate.of(2025, 6, 17)));

    }

}