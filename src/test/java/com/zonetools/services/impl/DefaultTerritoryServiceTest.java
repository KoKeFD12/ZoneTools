package com.zonetools.services.impl;

import com.zonetools.models.TerritoryModel;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.time.LocalDate;

@SpringBootTest
class DefaultTerritoryServiceTest {

    private static final Long INITIAL_ID = 1L;
    private static final Integer INITIAL_DOORS = 56;
    private static final String INITIAL_IMAGE_URL = "https://blank";
    private static final String INITIAL_OWNER = "Jorge";
    private static final LocalDate INITIAL_LAST_ASSIGNED = LocalDate.now();
    private static final LocalDate INITIAL_LAST_RETURNED = LocalDate.of(2024, 3, 14);

    private static final Integer CUSTOM_DOORS = 80;
    private static final String CUSTOM_IMAGE_URL = "https://not-blank";
    private static final String CUSTOM_OWNER = "Aitor";
    private static final LocalDate CUSTOM_LAST_ASSIGNED = LocalDate.of(2024, 7, 21);
    private static final LocalDate CUSTOM_LAST_RETURNED = LocalDate.of(2024, 2, 27);

    @Resource
    private DefaultTerritoryService defaultTerritoryService;

    private TerritoryModel territoryModel;

    @BeforeEach
    void setUp() {
        territoryModel= TerritoryModel.builder()
                      .id(INITIAL_ID)
                      .doors(INITIAL_DOORS)
                      .imageUrl(INITIAL_IMAGE_URL)
                      .owner(INITIAL_OWNER)
                      .lastAssigned(INITIAL_LAST_ASSIGNED)
                      .lastReturned(INITIAL_LAST_RETURNED)
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
    void findTerritoriesByNullOwner() {
        Assertions.assertTrue(defaultTerritoryService.findTerritoriesByOwner(null).isEmpty());
    }

    @Test
    void findTerritoryById() {
        Assertions.assertNotNull(defaultTerritoryService.findTerritoryById(territoryModel.getId()));
        Assertions.assertEquals(territoryModel, defaultTerritoryService.findTerritoryById(territoryModel.getId()).get());
    }

    @Test
    void findTerritoryByNullId() {
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class, () -> defaultTerritoryService.findTerritoryById(null));
    }

    @Test
    void saveTerritory() {
        TerritoryModel savedTerritoryModel = defaultTerritoryService.findTerritoryById(territoryModel.getId()).get();

        Assertions.assertEquals(INITIAL_ID, savedTerritoryModel.getId());
        Assertions.assertEquals(INITIAL_DOORS, savedTerritoryModel.getDoors());
        Assertions.assertEquals(INITIAL_IMAGE_URL, savedTerritoryModel.getImageUrl());
        Assertions.assertEquals(INITIAL_OWNER, savedTerritoryModel.getOwner());
        Assertions.assertEquals(INITIAL_LAST_ASSIGNED, savedTerritoryModel.getLastAssigned());
        Assertions.assertEquals(INITIAL_LAST_RETURNED, savedTerritoryModel.getLastReturned());
    }

    @Test
    void saveNullTerritory() {
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class, () -> defaultTerritoryService.saveTerritory(null));
    }

    @Test
    void deleteTerritory() {
        defaultTerritoryService.deleteTerritory(territoryModel);

        Assertions.assertTrue(defaultTerritoryService.findTerritoryById(territoryModel.getId()).isEmpty());
    }

    @Test
    void deleteNullTerritory() {
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class, () -> defaultTerritoryService.deleteTerritory(null));
    }

    @Test
    void updateTerritory() {
        territoryModel.setDoors(CUSTOM_DOORS);
        territoryModel.setImageUrl(CUSTOM_IMAGE_URL);
        territoryModel.setOwner(CUSTOM_OWNER);
        territoryModel.setLastAssigned(CUSTOM_LAST_ASSIGNED);
        territoryModel.setLastReturned(CUSTOM_LAST_RETURNED);

        defaultTerritoryService.saveTerritory(territoryModel);
        territoryModel = defaultTerritoryService.findTerritoryById(territoryModel.getId()).get();

        Assertions.assertEquals(CUSTOM_DOORS, territoryModel.getDoors());
        Assertions.assertEquals(CUSTOM_IMAGE_URL, territoryModel.getImageUrl());
        Assertions.assertEquals(CUSTOM_OWNER, territoryModel.getOwner());
        Assertions.assertEquals(CUSTOM_LAST_ASSIGNED, territoryModel.getLastAssigned());
        Assertions.assertEquals(CUSTOM_LAST_RETURNED, territoryModel.getLastReturned());
    }
}