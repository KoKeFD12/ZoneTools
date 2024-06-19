package com.zonetools.services;

import com.zonetools.models.MovementModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovementService {

    List<MovementModel> findAllMovements();

    Optional<MovementModel> findMovementById(Long id);

    List<MovementModel> findMovementsByDate(LocalDate date);

    List<MovementModel> findMovementsByTerritoryID(Long id);

    List<MovementModel> findMovementsByOwner(String owner);

    MovementModel saveMovement(MovementModel movementModel);

}
