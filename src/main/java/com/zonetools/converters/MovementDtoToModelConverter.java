package com.zonetools.converters;

import com.zonetools.dtos.MovementDto;
import com.zonetools.models.MovementModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovementDtoToModelConverter implements Converter<MovementDto, MovementModel> {

    @Override
    public MovementModel convert(MovementDto movementDto) {
        return MovementModel.builder()
                .id(movementDto.getId())
                .type(movementDto.getType())
                .territoryId(movementDto.getTerritoryId())
                .owner(movementDto.getOwner())
                .date(movementDto.getDate())
                .build();
    }

}