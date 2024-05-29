package com.znaji.springwebtasks.court.controller;

import com.znaji.springwebtasks.court.demain.Player;
import com.znaji.springwebtasks.court.demain.Reservation;
import com.znaji.springwebtasks.court.demain.SportType;
import com.znaji.springwebtasks.court.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
@RequiredArgsConstructor
public class ReservationFormController {

    private final ReservationService reservationService;

    @ModelAttribute("sportTypes")
    public List<SportType> populateSportTypes() {
        return reservationService.getAllSportTypes();
    }

    @GetMapping
    public String setupForm(Model model, @RequestParam(required = false, value = "username") String username) {
        var player = new Player(username);
        var reservation = new Reservation();
        reservation.setPlayer(player);
        model.addAttribute("reservation", reservation);
        return "reservationForm";
    }

    @PostMapping
    public String submitForm(@ModelAttribute("reservation") Reservation reservation) {
        reservationService.make(reservation);
        return "redirect:reservationSuccess";
    }
}
