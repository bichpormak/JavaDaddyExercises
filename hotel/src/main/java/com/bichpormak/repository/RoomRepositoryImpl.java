package com.bichpormak.repository;

import com.bichpormak.model.Room;

import java.time.LocalDate;
import java.util.*;

public class RoomRepositoryImpl implements RoomRepository {

    private static final Map<Room, List<LocalDate>> rooms = new HashMap<>();

    @Override
    public Optional<Room> findById(int roomId) {

        return rooms.keySet().stream()
                .filter(room -> room.id() == roomId)
                .findFirst();

    }

    @Override
    public List<Room> findAll() {

        return rooms.keySet().stream()
                .toList();

    }

    @Override
    public Optional<List<LocalDate>> findDatesByRoomId(int roomId) {

        return rooms.entrySet().stream()
                .filter(entry -> entry.getKey().id() == roomId)
                .findFirst()
                .map(Map.Entry::getValue);

    }

    @Override
    public void saveNewReservation(int roomId, List<LocalDate> dates) {

        rooms.putIfAbsent(new Room(roomId, "Какой-то тип", 5000), dates);

    }

}