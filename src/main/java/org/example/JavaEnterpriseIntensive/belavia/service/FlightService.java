package org.example.JavaEnterpriseIntensive.belavia.service;

import org.example.JavaEnterpriseIntensive.belavia.dao.FlightsDao;
import org.example.JavaEnterpriseIntensive.belavia.dto.AirPortDto;
import org.example.JavaEnterpriseIntensive.belavia.dto.FlightsDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightService {

    private FlightsDao dao = new FlightsDao();
    private List<FlightsDto> allFlights = dao.getAll();


    boolean flag1 = true;
    boolean flag2 = true;
    boolean flag3 = true;
    boolean flag4 = true;



    public List<FlightsDto> getFlightsList(String departureDate, String departureAirPort,
                                     String arrivalDate, String arrivalAirPort ) {
        try {
            dao.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        List<FlightsDto> filteredFlights = new ArrayList<>();
        for (FlightsDto flight : allFlights) {

            LocalDate scheduledDeparture = getDate(flight.getScheduled_departure());
            flag1 = getDate(departureDate) == null || getDate(departureDate).isEqual(scheduledDeparture);

            flag2 = departureAirPort.equalsIgnoreCase(flight.getDeparture_airport());

            LocalDate scheduledArrival = getDate(flight.getScheduled_arrival());
            flag3 = getDate(arrivalDate) == null || getDate(arrivalDate).isEqual(scheduledArrival);

            flag4 = arrivalAirPort.equalsIgnoreCase(flight.getArrival_airport());

            if(flag1 && flag2 && flag3 && flag4){
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }

    private LocalDate getDate(String fullDate){
        try{
            String strDate = fullDate.substring(0, 10);
            return LocalDate.parse(strDate);
        }catch (IndexOutOfBoundsException e){
            return null;
        }

    }
}
