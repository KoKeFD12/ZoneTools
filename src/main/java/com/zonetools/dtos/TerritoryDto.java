package com.zonetools.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class TerritoryDto {

    private Long id;

    private Integer doors;

    private String imageUrl;

    private String owner;

    private LocalDate lastAssigned;

    private LocalDate lastReturned;

}