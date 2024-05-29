package com.znaji.springwebtasks.court.controller;

import com.znaji.springwebtasks.court.exception.ReservationNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingAdvice {

    @ExceptionHandler(ReservationNotFoundException.class)
    public String reservationNotFound(Model model, ReservationNotFoundException ex) {
        model.addAttribute("exception", ex);
        return "reservationNotFound";
    }

    @ExceptionHandler
    public String generalException(Exception ex, Model model) {
        model.addAttribute("exception", ex);
        return "error";
    }
}
