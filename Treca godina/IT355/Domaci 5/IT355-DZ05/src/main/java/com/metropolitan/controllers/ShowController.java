package com.metropolitan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowController {
    @RequestMapping("prikaziPodatke")
    public ModelAndView prikaziPodatke(@RequestParam("name") String ime,
                                       @RequestParam("model") String marka,
                                       @RequestParam("carModel") String model,
                                       @RequestParam("numOfDays") int brDana){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", ime);
        mv.addObject("model", marka);
        mv.addObject("carModel", model);
        mv.addObject("numOfDays", brDana);
        mv.setViewName("prikaz.jsp");

        return mv;
    }
}