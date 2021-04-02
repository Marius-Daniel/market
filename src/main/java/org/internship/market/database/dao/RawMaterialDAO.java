package org.internship.market.database.dao;

import org.internship.market.database.entity.RawMaterialEntity;

import java.util.List;

public interface RawMaterialDAO {

    List<RawMaterialEntity> getAllMaterial();

    RawMaterialEntity getRawMaterialByName(String name);

    RawMaterialEntity createRawMaterial(RawMaterialEntity rawMaterialEntity);

    void updateRawMaterial(String name, double newPriceValue);

}
