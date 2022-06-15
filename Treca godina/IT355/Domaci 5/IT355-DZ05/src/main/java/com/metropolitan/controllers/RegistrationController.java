package com.metropolitan.controllers;

import com.metropolitan.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("registration", new User());
        return "index";
    }

    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("registration") User user,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            return "prikaz";
        }

    }
}