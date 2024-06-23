package com.zonetools.converters;

import com.zonetools.dtos.TerritoryDto;
import com.zonetools.models.TerritoryModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TerritoryModelToDtoConverterTest {

    private static final Long INITIAL_ID = 28L;
    private static final Integer INITIAL_DOORS = 58;
    private static final String INITIAL_IMAGE_URL = "https://blank";
    private static final String INITIAL_OWNER = "Jorge";
    private static final LocalDate INITIAL_LAST_ASSIGNED = LocalDate.now();
    private static final LocalDate INITIAL_LAST_RETURNED = LocalDate.of(2024, 3, 17);
    private static final TerritoryModelToDtoConverter TERRITORY_MODEL_TO_DTO_CONVERTER = new TerritoryModelToDtoConverter();

    @Test
    void convert() {
        TerritoryModel territoryModel = TerritoryModel.builder()
                                                .id(INITIAL_ID)
                                                .doors(INITIAL_DOORS)
                                                .imageUrl(INITIAL_IMAGE_URL)
                                                .owner(INITIAL_OWNER)
                                                .lastAssigned(INITIAL_LAST_ASSIGNED)
                                                .lastReturned(INITIAL_LAST_RETURNED)
                                                .build();

        TerritoryDto territoryDto = TERRITORY_MODEL_TO_DTO_CONVERTER.convert(territoryModel);

        Assertions.assertEquals(territoryModel.getId(), territoryDto.getId());
        Assertions.assertEquals(territoryModel.getDoors(), territoryDto.getDoors());
        Assertions.assertEquals(territoryModel.getImageUrl(), territoryDto.getImageUrl());
        Assertions.assertEquals(territoryModel.getOwner(), territoryDto.getOwner());
        Assertions.assertEquals(territoryModel.getLastAssigned(), territoryDto.getLastAssigned());
        Assertions.assertEquals(territoryModel.getLastReturned(), territoryDto.getLastReturned());
    }

    @Test
    void convertNull() {
        Assertions.assertThrows(NullPointerException.class, () -> TERRITORY_MODEL_TO_DTO_CONVERTER.convert(null));
    }

}