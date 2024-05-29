package com.znaji.springwebtasks.court.service;

import com.znaji.springwebtasks.court.demain.Player;
import com.znaji.springwebtasks.court.demain.Reservation;
import com.znaji.springwebtasks.court.demain.SportType;
import com.znaji.springwebtasks.court.exception.ReservationNotAvailableException;
import com.znaji.springwebtasks.court.exception.ReservationNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class InMemoryReservationService implements ReservationService
{

    private final List<Reservation> reservations = Collections.synchronizedList(new ArrayList<>());
    private static final SportType TENNIS = new SportType(1, "Tennis");
    private static final SportType SOCCER = new SportType(2, "Soccer");

    public InMemoryReservationService() {
        var roger = Player.builder().name("Roger").build();
        var rafael = Player.builder().name("Rafael").build();
        var date = LocalDate.of(2024, 5, 1);
        var tennis = SportType.builder().name("Tennis").build();
        reservations.add(new Reservation("Tennis", date, 16, roger, tennis));
        reservations.add(new Reservation("Tennis", date, 20, rafael, tennis));
    }

    @Override
    public List<Reservation> query(String courtName) {
        return reservations.stream()
                .filter(reservation -> StringUtils.startsWithIgnoreCase(reservation.getCourtName(), courtName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> findByDate(LocalDate summaryDate) {
        return reservations.stream()
                .filter( (r) -> Objects.equals(r.getDate(), summaryDate))
                .collect(Collectors.toList());
    }

    @Override
    public Reservation findReservation(String courtName, LocalDate date, int hour) {
        return reservations.stream()
                .filter( (r) -> Objects.equals(r.getCourtName(), courtName))
                .filter( (r) -> Objects.equals(r.getDate(), date))
                .filter( (r) -> r.getHour() == hour)
                .findFirst()
                .orElseThrow(() -> new ReservationNotFoundException(courtName, date, hour));
    }

    @Override
    public void make(Reservation reservation) {
        var count = reservations.stream()
                .filter( (r) -> Objects.equals(r.getCourtName(), reservation.getCourtName()))
                .filter( (r) -> Objects.equals(r.getDate(), reservation.getDate()))
                .filter( (r) -> r.getHour() == reservation.getHour())
                .count();
        if (count > 0) {
            throw new ReservationNotAvailableException(reservation.getCourtName(), reservation.getDate(), reservation.getHour());
        } else {
            reservations.add(reservation);
        }
    }

    @Override
    public List<SportType> getAllSportTypes() {
        return List.of(TENNIS, SOCCER);
    }


}
