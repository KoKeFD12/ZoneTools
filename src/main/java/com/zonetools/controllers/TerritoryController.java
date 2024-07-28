package com.zonetools.controllers;

import com.zonetools.facades.TerritoryFacade;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TerritoryController {

    @Resource
    private TerritoryFacade territoryFacade;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/movements")
    public String movements(Model model) {
        return "movements";
    }

    @GetMapping("/territories")
    public String territories(Model model) {
        model.addAttribute("territoriesList", territoryFacade.findAllTerritories());
        return "territories";
    }

}
