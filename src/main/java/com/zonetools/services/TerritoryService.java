package com.zonetools.services;

import com.zonetools.models.TerritoryModel;

import java.util.List;
import java.util.Optional;

public interface TerritoryService {

    List<TerritoryModel> findAllTerritories();

    List<TerritoryModel> findTerritoriesByOwner(String owner);

    Optional<TerritoryModel> findTerritoryById(Long id);

    TerritoryModel saveTerritory(TerritoryModel territory);

}