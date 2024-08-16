package com.zonetools.controllers;

import com.zonetools.dtos.MovementDto;
import com.zonetools.dtos.TerritoryDto;
import com.zonetools.facades.MovementFacade;
import com.zonetools.facades.TerritoryFacade;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TerritoryController {

    private static final String HOME_PAGE = "home";
    private static final String MOVEMENTS_PAGE = "movements";
    private static final String TERRITORIES_PAGE = "territories";
    private static final String NEW_TERRITORY_PAGE = "new-territory";
    private static final String NEW_MOVEMENT_PAGE = "new-movement";

    @Resource
    private TerritoryFacade territoryFacade;

    @Resource
    private MovementFacade movementFacade;

    @GetMapping("/")
    public String home(Model model) {
        return HOME_PAGE;
    }

    @GetMapping("/movements")
    public String movements(Model model) {
        model.addAttribute("movementsList", movementFacade.findAllMovements());
        return MOVEMENTS_PAGE;
    }

    @DeleteMapping("/movements/delete/{id}")
    public ResponseEntity<Long> deleteMovement(@PathVariable Long id) {
        if (movementFacade.findMovementById(id)
                          .isPresent()) {
            movementFacade.deleteMovement(movementFacade.findMovementById(id)
                                                        .get());
            return ResponseEntity.ok()
                                 .build();
        }

        return ResponseEntity.notFound()
                             .build();
    }

    @GetMapping("/movements/new-movement")
    public String newMovement(Model model) {
        model.addAttribute("movementDto", MovementDto.builder().build());
        return NEW_MOVEMENT_PAGE;
    }

    @PostMapping("/movements/new-movement")
    public String newMovementSubmit(@ModelAttribute MovementDto movementDto) {
        movementFacade.saveMovement(movementDto);
        return "redirect:" + "/movements";
    }

    @GetMapping("/territories")
    public String territories(Model model) {
        model.addAttribute("territoriesList", territoryFacade.findAllTerritories());
        return TERRITORIES_PAGE;
    }

    @GetMapping("/territories/new-territory")
    public String newTerritory(Model model) {
        model.addAttribute("territoryDto", TerritoryDto.builder()
                                                       .build());
        return NEW_TERRITORY_PAGE;
    }

    @PostMapping("/territories/new-territory")
    public String newTerritorySubmit(@ModelAttribute TerritoryDto territoryDto) {
        territoryFacade.saveTerritory(territoryDto);
        return "redirect:" + "/territories";
    }

}
