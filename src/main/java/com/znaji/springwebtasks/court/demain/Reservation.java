package com.znaji.springwebtasks.court.demain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {

    private String courtName;
    private LocalDate date;
    private int hour;
    private Player player;
    private SportType sportType;
}
