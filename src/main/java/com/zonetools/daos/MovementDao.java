package com.zonetools.daos;

import com.zonetools.models.MovementModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovementDao extends JpaRepository<MovementModel, Long> {

    List<MovementModel> findAllByDate(LocalDate date);

    List<MovementModel> findAllByTerritoryId(Long id);

    List<MovementModel> findAllByOwnerContaining(String owner);

}
