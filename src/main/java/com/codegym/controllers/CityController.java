package com.codegym.controllers;

import com.codegym.models.City;
import com.codegym.servies.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CityController {

    @Autowired
    private ICityService iCityService;



    @GetMapping("/list")
    public ModelAndView listCity() {
            Iterable<City> city = iCityService.findAll();
            ModelAndView modelAndView = new ModelAndView("/List");
            modelAndView.addObject("citys", city);
            return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        City city = iCityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetailForm(@PathVariable Long id) {
        City city = iCityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("city", city);
        return modelAndView;
    }


    @PostMapping("/edit/{id}")
    public ModelAndView editUser(@ModelAttribute City city) {
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        iCityService.save(city);
//        return "redirect:/list";
        return modelAndView;

    }

    @PostMapping("/create")
    public ModelAndView createUser( @ModelAttribute City user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/create");
            String message = "không được rống";
            model.addAttribute("message", message);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/list");
            iCityService.save(user);
//        return "redirect:/list";
            return modelAndView;
        }
    }


    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable Long id) {
        iCityService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        return modelAndView;
    }

}
