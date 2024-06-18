package com.zonetools.daos;

import com.zonetools.models.MovementModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementDao extends JpaRepository<MovementModel, Long> {

}
