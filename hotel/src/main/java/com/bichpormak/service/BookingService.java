package com.bichpormak.service;

import com.bichpormak.model.Room;
import com.bichpormak.repository.RoomRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingService {

    private final RoomRepository roomRepository;

    public BookingService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public boolean isRoomAvailable(Room room, LocalDate checkIn, LocalDate checkOut) {

        Optional<List<LocalDate>> dates = roomRepository.findDatesByRoomId(room.id());

        if (dates.isPresent()) {

            boolean lowerLimit = checkIn.isAfter(dates.get().get(1));
            boolean upLimit = checkOut.isBefore(dates.get().get(0));

            return lowerLimit || upLimit;

        }

        throw new IllegalStateException("Number not found");

    }

    public boolean bookRoom(Room room, LocalDate checkIn, LocalDate checkOut) {

        Optional<List<LocalDate>> dates = roomRepository.findDatesByRoomId(room.id());

        if (dates.isPresent()) {

            boolean lowerLimit = checkIn.isAfter(dates.get().get(1));
            boolean upLimit = checkOut.isBefore(dates.get().get(0));

            if (lowerLimit || upLimit) {

                roomRepository.saveNewReservation(room.id(), new ArrayList<>(List.of(checkIn, checkOut)));
                return true;

            }

        }

        return false;
    }

    public double calculatePrice(Room room, LocalDate checkIn, LocalDate checkOut) {

        return room.pricePerNight() * ChronoUnit.DAYS.between(checkIn, checkOut);

    }

}