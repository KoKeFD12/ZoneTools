package com.zonetools.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class MovementDto {

    private Long id;

    private Character type;

    private Long territoryId;

    private String owner;

    private LocalDate date;

}
