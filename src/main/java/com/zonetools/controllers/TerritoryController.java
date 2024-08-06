package com.zonetools.controllers;

import com.zonetools.dtos.TerritoryDto;
import com.zonetools.facades.TerritoryFacade;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("territoryDto", TerritoryDto.builder().build());
        return NEW_TERRITORY_PAGE;
    }

    @PostMapping("/territories/new-territory")
    public String newTerritorySubmit(@ModelAttribute TerritoryDto territoryDto) {
        territoryFacade.saveTerritory(territoryDto);
        return "redirect:"+"/territories";
    }

}
