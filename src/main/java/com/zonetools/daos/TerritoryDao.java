package com.zonetools.daos;

import com.zonetools.models.TerritoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TerritoryDao extends JpaRepository<TerritoryModel, Long> {

    List<TerritoryModel> findAllByOwnerContaining(String owner);

}
