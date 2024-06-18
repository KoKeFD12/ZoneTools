package com.zonetools.services.impl;

import com.zonetools.daos.MovementDao;
import com.zonetools.daos.TerritoryDao;
import com.zonetools.models.MovementModel;
import com.zonetools.models.TerritoryModel;
import com.zonetools.services.TerritoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DefaultTerritoryService implements TerritoryService {

    private final MovementDao movementDao;
    private final TerritoryDao territoryDao;

    @Override
    public List<TerritoryModel> findAllTerritories() {
        return territoryDao.findAll();
    }

    @Override
    public List<TerritoryModel> findTerritoriesByOwner(String owner) {
        return territoryDao.findAllByOwnerContaining(owner);
    }

    @Override
    public Optional<TerritoryModel> findTerritoryById(Long id) {
        return territoryDao.findById(id);
    }

    @Override
    public TerritoryModel saveTerritory(TerritoryModel territory) {
        return territoryDao.save(territory);
    }

    @Override
    public List<MovementModel> findAllMovements() {
        return movementDao.findAll();
    }

    @Override
    public Optional<MovementModel> findMovementById(Long id) {
        return movementDao.findById(id);
    }

    @Override
    public List<MovementModel> findMovementsByDate(LocalDate date) {
        return movementDao.findAllByDate(date);
    }

    @Override
    public List<MovementModel> findMovementsByTerritoryID(Long id) {
        return movementDao.findAllByTerritoryId(id);
    }

    @Override
    public List<MovementModel> findMovementsByOwner(String owner) {
        return movementDao.findAllByOwnerContaining(owner);
    }

    @Override
    public MovementModel saveMovement(MovementModel movementModel) {
        return movementDao.save(movementModel);
    }

}
