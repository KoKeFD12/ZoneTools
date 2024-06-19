package com.zonetools.facades.impl;

import com.zonetools.converters.MovementDtoToModelConverter;
import com.zonetools.converters.MovementModelToDtoConverter;
import com.zonetools.dtos.MovementDto;
import com.zonetools.facades.MovementFacade;
import com.zonetools.services.MovementService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MovementFacadeImpl implements MovementFacade {

    @Resource
    private MovementService movementService;

    @Resource
    private MovementDtoToModelConverter movementDtoToModelConverter;

    @Resource
    private MovementModelToDtoConverter movementModelToDtoConverter;

    @Override
    public List<MovementDto> findAllMovements() {
        return movementService.findAllMovements()
                              .stream()
                              .map(movementModel -> movementModelToDtoConverter.convert(movementModel))
                              .collect(Collectors.toList());
    }

    @Override
    public Optional<MovementDto> findMovementById(Long id) {
        return movementService.findMovementById(id)
                              .map(movementModelToDtoConverter::convert);
    }

    @Override
    public List<MovementDto> findMovementsByDate(LocalDate date) {
        return movementService.findMovementsByDate(date)
                              .stream()
                              .map(movementModel -> movementModelToDtoConverter.convert(movementModel))
                              .collect(Collectors.toList());
    }

    @Override
    public List<MovementDto> findMovementsByTerritoryID(Long id) {
        return movementService.findMovementsByTerritoryID(id)
                              .stream()
                              .map(movementModel -> movementModelToDtoConverter.convert(movementModel))
                              .collect(Collectors.toList());
    }

    @Override
    public List<MovementDto> findMovementsByOwner(String owner) {
        return movementService.findMovementsByOwner(owner)
                              .stream()
                              .map(movementModel -> movementModelToDtoConverter.convert(movementModel))
                              .collect(Collectors.toList());
    }

    @Override
    public MovementDto saveMovement(MovementDto movementDto) {
        return movementModelToDtoConverter.convert(movementService.saveMovement(movementDtoToModelConverter.convert(movementDto)));
    }

    @Override
    public void deleteMovement(MovementDto movementDto) {
        movementService.deleteMovement(movementDtoToModelConverter.convert(movementDto));
    }

}
