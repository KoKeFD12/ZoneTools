package com.zonetools.converters;

import com.zonetools.dtos.TerritoryDto;
import com.zonetools.models.TerritoryModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TerritoryDtoToModelConverter implements Converter<TerritoryDto, TerritoryModel> {

    @Override
    public TerritoryModel convert(TerritoryDto territoryDto) {
        return TerritoryModel.builder()
                .id(territoryDto.getId())
                .doors(territoryDto.getDoors())
                .imageUrl(territoryDto.getImageUrl())
                .owner(territoryDto.getOwner())
                .lastAssigned(territoryDto.getLastAssigned())
                .lastReturned(territoryDto.getLastReturned())
                .build();
    }

}