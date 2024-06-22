package com.zonetools.services.impl;

import com.zonetools.models.TerritoryModel;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class DefaultTerritoryServiceTest {

    @Resource
    private DefaultTerritoryService defaultTerritoryService;

    private TerritoryModel territoryModel;

    @BeforeEach
    void setUp() {
        territoryModel= TerritoryModel.builder()
                      .id(1L)
                      .doors(56)
                      .imageUrl("https://blank")
                      .owner("Jorge")
                      .lastAssigned(LocalDate.now())
                      .lastReturned(LocalDate.of(2024, 3, 14))
                      .build();
        territoryModel = defaultTerritoryService.saveTerritory(territoryModel);
    }

    @AfterEach
    void tearDown() {
        defaultTerritoryService.findAllTerritories().forEach(territory -> defaultTerritoryService.deleteTerritory(territory));
    }

    @Test
    void findAllTerritories() {
        Assertions.assertNotNull(defaultTerritoryService.findAllTerritories());
        Assertions.assertFalse(defaultTerritoryService.findAllTerritories().isEmpty());
    }

    @Test
    void findTerritoriesByOwner() {
        Assertions.assertNotNull(defaultTerritoryService.findTerritoriesByOwner(territoryModel.getOwner()));
        Assertions.assertFalse(defaultTerritoryService.findTerritoriesByOwner(territoryModel.getOwner()).isEmpty());
        Assertions.assertTrue(defaultTerritoryService.findTerritoriesByOwner(territoryModel.getOwner()).contains(territoryModel));
    }

    @Test
    void findTerritoryById() {
        Assertions.assertNotNull(defaultTerritoryService.findTerritoryById(territoryModel.getId()));
        Assertions.assertEquals(territoryModel, defaultTerritoryService.findTerritoryById(territoryModel.getId()).get());
    }

    @Test
    void saveTerritory() {
        TerritoryModel savedTerritoryModel = defaultTerritoryService.findTerritoryById(territoryModel.getId()).get();

        Assertions.assertEquals(territoryModel.getId(), savedTerritoryModel.getId());
        Assertions.assertEquals(territoryModel.getDoors(), savedTerritoryModel.getDoors());
        Assertions.assertEquals(territoryModel.getImageUrl(), savedTerritoryModel.getImageUrl());
        Assertions.assertEquals(territoryModel.getOwner(), savedTerritoryModel.getOwner());
        Assertions.assertEquals(territoryModel.getLastAssigned(), savedTerritoryModel.getLastAssigned());
        Assertions.assertEquals(territoryModel.getLastReturned(), savedTerritoryModel.getLastReturned());
    }

    @Test
    void deleteTerritory() {
        defaultTerritoryService.deleteTerritory(territoryModel);

        Assertions.assertTrue(defaultTerritoryService.findTerritoryById(territoryModel.getId()).isEmpty());
    }
}