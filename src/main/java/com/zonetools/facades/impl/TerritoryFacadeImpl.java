package com.zonetools.facades.impl;

import com.zonetools.converters.TerritoryDtoToModelConverter;
import com.zonetools.converters.TerritoryModelToDtoConverter;
import com.zonetools.dtos.TerritoryDto;
import com.zonetools.facades.TerritoryFacade;
import com.zonetools.services.TerritoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TerritoryFacadeImpl implements TerritoryFacade {

    @Resource
    private TerritoryService territoryService;

    @Resource
    private TerritoryDtoToModelConverter territoryDtoToModelConverter;

    @Resource
    private TerritoryModelToDtoConverter territoryModelToDtoConverter;

    @Override
    public List<TerritoryDto> findAllTerritories() {
        return territoryService.findAllTerritories()
                               .stream()
                               .map(territoryModel -> territoryModelToDtoConverter.convert(territoryModel))
                               .collect(Collectors.toList());
    }

    @Override
    public List<TerritoryDto> findTerritoriesByOwner(String owner) {
        return territoryService.findTerritoriesByOwner(owner)
                               .stream()
                               .map(territoryModel -> territoryModelToDtoConverter.convert(territoryModel))
                               .collect(Collectors.toList());
    }

    @Override
    public Optional<TerritoryDto> findTerritoryById(Long id) {
        return territoryService.findTerritoryById(id)
                               .map(territoryModelToDtoConverter::convert);
    }

    @Override
    public TerritoryDto saveTerritory(TerritoryDto territory) {
        return territoryModelToDtoConverter.convert(territoryService.saveTerritory(territoryDtoToModelConverter.convert(territory)));
    }

    @Override
    public void deleteTerritory(TerritoryDto territory) {
        territoryService.deleteTerritory(territoryDtoToModelConverter.convert(territory));
    }

}
