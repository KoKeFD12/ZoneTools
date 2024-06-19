package com.zonetools.services.impl;

import com.zonetools.daos.MovementDao;
import com.zonetools.models.MovementModel;
import com.zonetools.services.MovementService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DefaultMovementService implements MovementService {

    private final MovementDao movementDao;

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
