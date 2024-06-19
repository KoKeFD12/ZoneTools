package com.zonetools.converters;

import com.zonetools.dtos.TerritoryDto;
import com.zonetools.models.TerritoryModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TerritoryModelToDtoConverter implements Converter<TerritoryModel, TerritoryDto> {

    @Override
    public TerritoryDto convert(TerritoryModel territoryModel) {
        return TerritoryDto.builder()
                .id(territoryModel.getId())
                .doors(territoryModel.getDoors())
                .imageUrl(territoryModel.getImageUrl())
                .owner(territoryModel.getOwner())
                .lastAssigned(territoryModel.getLastAssigned())
                .lastReturned(territoryModel.getLastReturned())
                .build();
    }

}