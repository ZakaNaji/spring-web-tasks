package com.znaji.springwebtasks.court.config;

import com.znaji.springwebtasks.court.demain.SportType;
import com.znaji.springwebtasks.court.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SportTypeConverter implements Converter<String, SportType> {

    private final ReservationService reservationService;

    @Override
    public SportType convert(String source) {
        return reservationService.getSportById(Integer.parseInt(source));
    }
}
