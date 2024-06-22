package com.zonetools.controllers;

import com.zonetools.facades.TerritoryFacade;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class TerritoryController {

    @Resource
    private TerritoryFacade territoryFacade;

}
