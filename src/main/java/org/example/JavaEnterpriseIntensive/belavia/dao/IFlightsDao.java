package org.example.JavaEnterpriseIntensive.belavia.dao;

import org.example.JavaEnterpriseIntensive.belavia.dto.FlightsDto;

import java.util.List;

public interface IFlightsDao extends AutoCloseable {
    /**
     * get all airports
     * @return
     */
    List<FlightsDto> getAll();

    /**
     * get 1 airport
     *
     * @param code
     * @return
     */
    List<FlightsDto> get(String code);


}
