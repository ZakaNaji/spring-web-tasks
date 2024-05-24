package com.znaji.springwebtasks.court.controller;

import com.znaji.springwebtasks.court.demain.Reservation;
import com.znaji.springwebtasks.court.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
@RequestMapping("/reservationQuery")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

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

}
