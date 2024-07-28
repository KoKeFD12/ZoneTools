package com.zonetools.controllers;

import com.zonetools.facades.TerritoryFacade;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TerritoryController {

    private static final String HOME_PAGE = "home";
    private static final String MOVEMENTS_PAGE = "movements";
    private static final String TERRITORIES_PAGE = "territories";
    private static final String NEW_TERRITORY_PAGE = "new-territory";

    @Resource
    private TerritoryFacade territoryFacade;

    @GetMapping("/")
    public String home(Model model) {
        return HOME_PAGE;
    }

    @GetMapping("/movements")
    public String movements(Model model) {
        return MOVEMENTS_PAGE;
    }

    @GetMapping("/territories")
    public String territories(Model model) {
        model.addAttribute("territoriesList", territoryFacade.findAllTerritories());
        return TERRITORIES_PAGE;
    }

    @GetMapping("/territories/new-territory")
    public String newTerritory(Model model) {
        return NEW_TERRITORY_PAGE;
    }

}
