package com.zonetools.facades;

import com.zonetools.dtos.MovementDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovementFacade {

    List<MovementDto> findAllMovements();

    Optional<MovementDto> findMovementById(Long id);

    List<MovementDto> findMovementsByDate(LocalDate date);

    List<MovementDto> findMovementsByTerritoryID(Long id);

    List<MovementDto> findMovementsByOwner(String owner);

    MovementDto saveMovement(MovementDto movementDto);

    void deleteMovement(MovementDto movementDto);

}
