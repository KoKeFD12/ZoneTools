package com.zonetools.converters;

import com.zonetools.dtos.MovementDto;
import com.zonetools.models.MovementModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovementModelToDtoConverter implements Converter<MovementModel, MovementDto> {

    @Override
    public MovementDto convert(MovementModel movementModel) {
        return MovementDto.builder()
                .id(movementModel.getId())
                .type(movementModel.getType())
                .territoryId(movementModel.getTerritoryId())
                .owner(movementModel.getOwner())
                .date(movementModel.getDate())
                .build();
    }

}
