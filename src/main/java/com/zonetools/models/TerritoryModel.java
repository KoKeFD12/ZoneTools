package com.zonetools.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "territories")
public class TerritoryModel {

    @Id
    private int id;

    private int doors;

    @Column(name = "image_url")
    private String imageUrl;

    private String owner;

    @Column(name = "last_assigned")
    private LocalDate lastAssigned;

    @Column(name = "last_returned")
    private LocalDate lastReturned;

}
