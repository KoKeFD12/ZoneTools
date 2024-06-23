package com.zonetools.converters;

import com.zonetools.dtos.TerritoryDto;
import com.zonetools.models.TerritoryModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TerritoryDtoToModelConverterTest {

    private static final Long INITIAL_ID = 28L;
    private static final Integer INITIAL_DOORS = 58;
    private static final String INITIAL_IMAGE_URL = "https://blank";
    private static final String INITIAL_OWNER = "Jorge";
    private static final LocalDate INITIAL_LAST_ASSIGNED = LocalDate.now();
    private static final LocalDate INITIAL_LAST_RETURNED = LocalDate.of(2024, 3, 17);
    private static final TerritoryDtoToModelConverter TERRITORY_DTO_TO_MODEL_CONVERTER = new TerritoryDtoToModelConverter();

    @Test
    void convert() {
        TerritoryDto territoryDto = TerritoryDto.builder()
                                                .id(INITIAL_ID)
                                                .doors(INITIAL_DOORS)
                                                .imageUrl(INITIAL_IMAGE_URL)
                                                .owner(INITIAL_OWNER)
                                                .lastAssigned(INITIAL_LAST_ASSIGNED)
                                                .lastReturned(INITIAL_LAST_RETURNED)
                                                .build();

        TerritoryModel territoryModel = TERRITORY_DTO_TO_MODEL_CONVERTER.convert(territoryDto);

        Assertions.assertEquals(territoryDto.getId(), territoryModel.getId());
        Assertions.assertEquals(territoryDto.getDoors(), territoryModel.getDoors());
        Assertions.assertEquals(territoryDto.getImageUrl(), territoryModel.getImageUrl());
        Assertions.assertEquals(territoryDto.getOwner(), territoryModel.getOwner());
        Assertions.assertEquals(territoryDto.getLastAssigned(), territoryModel.getLastAssigned());
        Assertions.assertEquals(territoryDto.getLastReturned(), territoryModel.getLastReturned());
    }

    @Test
    void convertNull() {
        Assertions.assertThrows(NullPointerException.class, () -> TERRITORY_DTO_TO_MODEL_CONVERTER.convert(null));
    }

}