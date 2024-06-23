package com.zonetools.converters;

import com.zonetools.dtos.MovementDto;
import com.zonetools.models.MovementModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MovementModelToDtoConverterTest {

    private static final Character INITIAL_TYPE = 'I';
    private static final Long INITIAL_TERRITORY_ID = 28L;
    private static final String INITIAL_OWNER = "Jorge";
    private static final LocalDate INITIAL_DATE = LocalDate.now();
    private static final MovementModelToDtoConverter MOVEMENT_MODEL_TO_DTO_CONVERTER = new MovementModelToDtoConverter();

    @Test
    void convert() {
        MovementModel movementModel = MovementModel.builder()
                                             .type(INITIAL_TYPE)
                                             .territoryId(INITIAL_TERRITORY_ID)
                                             .owner(INITIAL_OWNER)
                                             .date(INITIAL_DATE)
                                             .build();

        MovementDto movementDto = MOVEMENT_MODEL_TO_DTO_CONVERTER.convert(movementModel);

        Assertions.assertEquals(movementModel.getId(), movementDto.getId());
        Assertions.assertEquals(movementModel.getType(), movementDto.getType());
        Assertions.assertEquals(movementModel.getTerritoryId(), movementDto.getTerritoryId());
        Assertions.assertEquals(movementModel.getOwner(), movementDto.getOwner());
        Assertions.assertEquals(movementModel.getDate(), movementDto.getDate());
    }

    @Test
    void convertNull() {
        Assertions.assertThrows(NullPointerException.class, () -> MOVEMENT_MODEL_TO_DTO_CONVERTER.convert(null));
    }

}