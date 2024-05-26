package com.znaji.springwebtasks.court.service;

import com.znaji.springwebtasks.court.demain.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    List<Reservation> query(String courtName);
    List<Reservation> findByDate(LocalDate date);
}
