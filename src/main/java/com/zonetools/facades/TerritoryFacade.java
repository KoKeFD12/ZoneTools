package com.zonetools.facades;

import com.zonetools.dtos.TerritoryDto;

import java.util.List;
import java.util.Optional;

public interface TerritoryFacade {

    List<TerritoryDto> findAllTerritories();

    List<TerritoryDto> findTerritoriesByOwner(String owner);

    Optional<TerritoryDto> findTerritoryById(Long id);

    TerritoryDto saveTerritory(TerritoryDto territory);

    void deleteTerritory(TerritoryDto territory);

}
