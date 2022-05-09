package org.example.JavaEnterpriseIntensive.belavia.dao;

import org.example.JavaEnterpriseIntensive.belavia.dto.AirPortDto;
import org.example.JavaEnterpriseIntensive.belavia.dto.FlightsDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightsDao implements IFlightsDao{
    List<AirPortDto> flightsDtos;

    public List<FlightsDto> getAll(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("CHECK DRIVER PATH", e);
        }
        flightsDtos = new ArrayList<>();
        try(
                Connection connection = getConnnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery
                        (
                                "SELECT\n" +
                                        "    flight_id,\n" +
                                        "    flight_no,\n" +
                                        "    scheduled_departure,\n" +
                                        "    scheduled_arrival,\n" +
                                        "    departure_airport,\n" +
                                        "    arrival_airport,\n" +
                                        "    status,\n" +
                                        "    aircraft_code,\n" +
                                        "    actual_departure,\n" +
                                        "    actual_arrival\n" +
                                        "FROM\n" +
                                        "    bookings.flights;\n"
                        );
        ){
            return getFlightsList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FlightsDto> get(String flight_id) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("CHECK DRIVER PATH", e);
        }
        try (
                Connection connection = getConnnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery
                        (
                                "SELECT\n" +
                                        "    flight_id,\n" +
                                        "    flight_no,\n" +
                                        "    scheduled_departure,\n" +
                                        "    scheduled_arrival,\n" +
                                        "    departure_airport,\n" +
                                        "    arrival_airport,\n" +
                                        "    status,\n" +
                                        "    aircraft_code,\n" +
                                        "    actual_departure,\n" +
                                        "    actual_arrival\n" +
                                        "FROM\n" +
                                        "    bookings.flights;\n " +
                                        "WHERE\n" +
                                        "    flight_id='" + flight_id + "';"
                        );
        ) {
            return getFlightsList(resultSet);
        }
        catch (SQLException e) {}
        return null;
    }


    private Connection getConnnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/demo",
                "postgres",
                "postgres");
        return connection;
    }


    private List<FlightsDto> getFlightsList(ResultSet resultSet) throws SQLException {
        List<FlightsDto> FlightsList = new ArrayList<>();
        while(resultSet.next()){
            FlightsList.add(new FlightsDto(

                    Integer.parseInt(resultSet.getString("flight_id")),
                    resultSet.getString("flight_no"),
                    resultSet.getString("scheduled_departure"),
                    resultSet.getString("scheduled_arrival"),
                    resultSet.getString("departure_airport"),
                    resultSet.getString("arrival_airport"),
                    resultSet.getString("status"),
                    resultSet.getString("aircraft_code"),
                    resultSet.getString("actual_departure"),
                    resultSet.getString("actual_arrival")
            ));
        }
        return FlightsList;
    }

    @Override
    public void close() throws Exception {

    }
}
