package com.zonetools.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class MovementDto {

    private Long id;

    @NotEmpty
    private Character type;

    @NotEmpty
    private Long territoryId;

    private String owner;

    private LocalDate date;

}
