package com.zonetools.services.impl;

import com.zonetools.daos.TerritoryDao;
import com.zonetools.models.TerritoryModel;
import com.zonetools.services.TerritoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DefaultTerritoryService implements TerritoryService {

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
    public void deleteTerritory(TerritoryModel territory) {
        territoryDao.delete(territory);
    }

}
