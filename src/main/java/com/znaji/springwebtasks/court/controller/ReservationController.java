package com.znaji.springwebtasks.court.controller;

import com.znaji.springwebtasks.court.demain.Reservation;
import com.znaji.springwebtasks.court.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/reservationQuery")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final MessageSource messageSource;

    @GetMapping("/home")
    public String welcome(Model model, Locale locale) {
        var message = messageSource.getMessage("welcome.message", null, locale);
        var localeMessage = messageSource.getMessage("current.locale", null, locale);
        model.addAttribute("message", message);
        model.addAttribute("localeMessage", localeMessage);
        model.addAttribute("locale", locale);
        return "welcome";
    }

    @GetMapping
    public void setUpForm() {
    }

    @PostMapping
    public void submitForm(@RequestParam("courtName") String courtName, Model model) {
        var reservations = Collections.<Reservation>emptyList();
        if (courtName != null) {
            reservations = reservationService.query(courtName);
        }
        model.addAttribute("reservations", reservations);
    }

    @GetMapping("reservationSummary")
    public String testList(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, Model model) {
        model.addAttribute("reservations", reservationService.findByDate(LocalDate.of(2024, 5, 1)));
        return "reservationSummary";
    }

}
