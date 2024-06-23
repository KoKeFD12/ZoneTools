package com.zonetools.converters;

import com.zonetools.dtos.MovementDto;
import com.zonetools.models.MovementModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class MovementDtoToModelConverterTest {

    private static final Character INITIAL_TYPE = 'I';
    private static final Long INITIAL_TERRITORY_ID = 28L;
    private static final String INITIAL_OWNER = "Jorge";
    private static final LocalDate INITIAL_DATE = LocalDate.now();
    private static final MovementDtoToModelConverter MOVEMENT_DTO_TO_MODEL_CONVERTER = new MovementDtoToModelConverter();

    @Test
    void convert() {
        MovementDto movementDto = MovementDto.builder()
                                             .type(INITIAL_TYPE)
                                             .territoryId(INITIAL_TERRITORY_ID)
                                             .owner(INITIAL_OWNER)
                                             .date(INITIAL_DATE)
                                             .build();

        MovementModel movementModel = MOVEMENT_DTO_TO_MODEL_CONVERTER.convert(movementDto);

        Assertions.assertEquals(movementDto.getId(), movementModel.getId());
        Assertions.assertEquals(movementDto.getType(), movementModel.getType());
        Assertions.assertEquals(movementDto.getTerritoryId(), movementModel.getTerritoryId());
        Assertions.assertEquals(movementDto.getOwner(), movementModel.getOwner());
        Assertions.assertEquals(movementDto.getDate(), movementModel.getDate());
    }

    @Test
    void convertNull() {
        Assertions.assertThrows(NullPointerException.class, () -> MOVEMENT_DTO_TO_MODEL_CONVERTER.convert(null));
    }

}