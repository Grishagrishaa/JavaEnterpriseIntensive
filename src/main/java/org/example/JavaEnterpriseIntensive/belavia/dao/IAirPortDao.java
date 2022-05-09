package org.example.JavaEnterpriseIntensive.belavia.dao;

import org.example.JavaEnterpriseIntensive.belavia.dto.AirPortDto;

import java.util.List;

public interface IAirPortDao extends AutoCloseable {
    /**
     * get all airports
     * @return
     */
    List<AirPortDto> getAll();

    /**
     * get 1 airport
     * @param code
     * @return
     */
    List<AirPortDto> get(String code);


}
