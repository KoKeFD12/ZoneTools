package com.zonetools.services.impl;

import com.zonetools.models.MovementModel;
import com.zonetools.models.TerritoryModel;
import com.zonetools.services.TerritoryService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class DefaultTerritoryService implements TerritoryService {
    @Override
    public List<TerritoryModel> findAllTerritories() {
        return List.of();
    }

    @Override
    public List<TerritoryModel> findTerritoriesByOwner(String owner) {
        return List.of();
    }

    @Override
    public Optional<TerritoryModel> findTerritoryById(Long id) {
        return Optional.empty();
    }

    @Override
    public TerritoryModel saveTerritory(TerritoryModel territory) {
        return null;
    }

    @Override
    public List<MovementModel> findAllMovements() {
        return List.of();
    }

    @Override
    public Optional<MovementModel> findMovementById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<MovementModel> findMovementByDate(LocalDate date) {
        return Optional.empty();
    }

    @Override
    public List<MovementModel> findMovementsByTerritoryID(Long id) {
        return List.of();
    }

    @Override
    public List<MovementModel> findMovementsByOwner(String owner) {
        return List.of();
    }

    @Override
    public MovementModel saveMovement(MovementModel movementModel) {
        return null;
    }
}
