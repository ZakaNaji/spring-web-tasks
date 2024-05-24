package com.znaji.springwebtasks.court.service;

import com.znaji.springwebtasks.court.demain.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> query(String courtName);
}
