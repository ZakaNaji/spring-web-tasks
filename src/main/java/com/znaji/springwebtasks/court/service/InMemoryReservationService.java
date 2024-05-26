package com.znaji.springwebtasks.court.service;

import com.znaji.springwebtasks.court.demain.Player;
import com.znaji.springwebtasks.court.demain.Reservation;
import com.znaji.springwebtasks.court.demain.SportType;
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
}
