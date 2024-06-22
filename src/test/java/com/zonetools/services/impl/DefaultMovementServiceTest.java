package com.zonetools.services.impl;

import com.zonetools.models.MovementModel;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.time.LocalDate;

@SpringBootTest
class DefaultMovementServiceTest {

    private static final Character INITIAL_TYPE = 'I';
    private static final Long INITIAL_TERRITORY_ID = 28L;
    private static final String INITIAL_OWNER = "Jorge";
    private static final LocalDate INITIAL_DATE = LocalDate.now();

    private static final Character CUSTOM_TYPE = 'O';
    private static final Long CUSTOM_TERRITORY_ID = 17L;
    private static final String CUSTOM_OWNER = "Aitor";
    private static final LocalDate CUSTOM_DATE = LocalDate.of(2024, 6, 21);

    @Resource
    private DefaultMovementService defaultMovementService;

    private MovementModel movementModel;

    @BeforeEach
    void setUp() {
        movementModel = MovementModel.builder()
                                     .type(INITIAL_TYPE)
                                     .territoryId(INITIAL_TERRITORY_ID)
                                     .owner(INITIAL_OWNER)
                                     .date(INITIAL_DATE)
                                     .build();

        defaultMovementService.saveMovement(movementModel);
    }

    @AfterEach
    void tearDown() {
        defaultMovementService.findAllMovements().forEach(movement -> defaultMovementService.deleteMovement(movement));
    }

    @Test
    void findAllMovements() {
        Assertions.assertNotNull(defaultMovementService.findAllMovements());
        Assertions.assertFalse(defaultMovementService.findAllMovements().isEmpty());
    }

    @Test
    void findMovementById() {
        Assertions.assertNotNull(defaultMovementService.findMovementById(movementModel.getId()));
        Assertions.assertEquals(movementModel, defaultMovementService.findMovementById(movementModel.getId()).get());
    }

    @Test
    void findMovementByNullId() {
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class, () -> defaultMovementService.findMovementById(null));
    }

    @Test
    void findMovementsByDate() {
        Assertions.assertNotNull(defaultMovementService.findMovementsByDate(movementModel.getDate()));
        Assertions.assertFalse(defaultMovementService.findMovementsByDate(movementModel.getDate()).isEmpty());
        defaultMovementService.findMovementsByDate(movementModel.getDate()).forEach(movement -> Assertions.assertEquals(INITIAL_DATE, movement.getDate()));
    }

    @Test
    void findMovementsByNullDate() {
        Assertions.assertTrue(defaultMovementService.findMovementsByDate(null).isEmpty());
    }

    @Test
    void findMovementsByTerritoryID() {
        Assertions.assertNotNull(defaultMovementService.findMovementsByTerritoryID(movementModel.getId()));
        Assertions.assertFalse(defaultMovementService.findMovementsByTerritoryID(movementModel.getTerritoryId()).isEmpty());
    }

    @Test
    void findMovementsByNullTerritoryID() {
        Assertions.assertTrue(defaultMovementService.findMovementsByTerritoryID(null).isEmpty());
    }

    @Test
    void findMovementsByOwner() {
        Assertions.assertNotNull(defaultMovementService.findMovementsByOwner(movementModel.getOwner()));
        Assertions.assertFalse(defaultMovementService.findMovementsByOwner(movementModel.getOwner()).isEmpty());
        defaultMovementService.findMovementsByOwner(movementModel.getOwner()).forEach(movement -> Assertions.assertEquals(INITIAL_OWNER, movement.getOwner()));
    }

    @Test
    void findMovementsByNullOwner() {
        Assertions.assertTrue(defaultMovementService.findMovementsByOwner(null).isEmpty());
    }

    @Test
    void saveMovement() {
        MovementModel savedMovementModel = defaultMovementService.findMovementById(movementModel.getId()).get();

        Assertions.assertEquals(INITIAL_TYPE, savedMovementModel.getType());
        Assertions.assertEquals(INITIAL_TERRITORY_ID, savedMovementModel.getTerritoryId());
        Assertions.assertEquals(INITIAL_OWNER, savedMovementModel.getOwner());
        Assertions.assertEquals(INITIAL_DATE, savedMovementModel.getDate());
    }

    @Test
    void saveNullMovement() {
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class, () -> defaultMovementService.saveMovement(null));
    }

    @Test
    void deleteMovement() {
        defaultMovementService.deleteMovement(movementModel);

        Assertions.assertTrue(defaultMovementService.findMovementById(movementModel.getId()).isEmpty());
    }

    @Test
    void deleteNullMovement() {
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class, () -> defaultMovementService.deleteMovement(null));
    }

    @Test
    void updateMovement() {
        movementModel.setType(CUSTOM_TYPE);
        movementModel.setTerritoryId(CUSTOM_TERRITORY_ID);
        movementModel.setOwner(CUSTOM_OWNER);
        movementModel.setDate(CUSTOM_DATE);

        defaultMovementService.saveMovement(movementModel);
        movementModel = defaultMovementService.findMovementById(movementModel.getId()).get();

        Assertions.assertEquals(CUSTOM_TYPE, movementModel.getType());
        Assertions.assertEquals(CUSTOM_TERRITORY_ID, movementModel.getTerritoryId());
        Assertions.assertEquals(CUSTOM_OWNER, movementModel.getOwner());
        Assertions.assertEquals(CUSTOM_DATE, movementModel.getDate());
    }
}