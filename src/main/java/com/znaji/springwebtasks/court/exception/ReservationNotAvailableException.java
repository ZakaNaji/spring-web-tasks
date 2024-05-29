package com.znaji.springwebtasks.court.exception;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ReservationNotAvailableException extends RuntimeException {
    public static final long serialVersionUID = 1L;
    private final String courtName;
    private final LocalDate date;
    private final int hour;
    public ReservationNotAvailableException(String courtName, LocalDate date, int hour) {
        this.courtName = courtName;
        this.date = date;
        this.hour = hour;
    }
}
