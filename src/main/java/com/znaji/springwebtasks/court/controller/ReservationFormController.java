package com.znaji.springwebtasks.court.controller;

import com.znaji.springwebtasks.court.demain.Player;
import com.znaji.springwebtasks.court.demain.Reservation;
import com.znaji.springwebtasks.court.demain.ReservationValidation;
import com.znaji.springwebtasks.court.demain.SportType;
import com.znaji.springwebtasks.court.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
@RequiredArgsConstructor
public class ReservationFormController {

    private final ReservationService reservationService;
    public final ReservationValidation reservationValidation;

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
    public String submitForm(@ModelAttribute("reservation") @Validated Reservation reservation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "reservationForm";
        }
        reservationService.make(reservation);
        return "redirect:/reservationForm/reservationSuccess";
    }

    @GetMapping("reservationSuccess")
    public String success() {
        return "reservationSuccess";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(reservationValidation);
    }
}
