package com.zonetools.controllers;

import com.zonetools.facades.TerritoryFacade;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TerritoryController {

    @Resource
    private TerritoryFacade territoryFacade;

    @RequestMapping("/home")
    public String home(Model model) {
        return "home";
    }

}
