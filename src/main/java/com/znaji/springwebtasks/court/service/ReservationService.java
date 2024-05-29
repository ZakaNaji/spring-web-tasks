package com.znaji.springwebtasks.court.service;

import com.znaji.springwebtasks.court.demain.Reservation;
import com.znaji.springwebtasks.court.demain.SportType;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    List<Reservation> query(String courtName);
    List<Reservation> findByDate(LocalDate date);

    Reservation findReservation(String courtName, LocalDate date, int hour);

    void make(Reservation reservation);

    List<SportType> getAllSportTypes();
}
