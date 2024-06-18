package com.zonetools.daos;

import com.zonetools.models.TerritoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoryDao extends JpaRepository<TerritoryModel, Long> {

}
