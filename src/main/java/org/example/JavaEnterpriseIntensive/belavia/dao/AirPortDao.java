package org.example.JavaEnterpriseIntensive.belavia.dao;

import org.example.JavaEnterpriseIntensive.belavia.dto.AirPortDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirPortDao implements IAirPortDao{
    List<AirPortDto> airPortDtos;

    public List<AirPortDto> getAll(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("CHECK DRIVER PATH", e);
        }
        airPortDtos = new ArrayList<>();
        try(
                Connection connection = getConnnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery
                        (
                                "SELECT airport_code,\n" +
                                        "       airport_name,\n" +
                                        "       city,\n" +
                                        "       coordinates,\n" +
                                        "       timezone\n" +
                                        "FROM   bookings.airports_data\n" +
                                        "ORDER  BY city; "
                        );
        ){
            return getAirPortsList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<AirPortDto> get(String code) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("CHECK DRIVER PATH", e);
        }
        AirPortDto airPortDto = null;
        try (
                Connection connection = getConnnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery
                        (
                                "SELECT\n" +
                                        "    airport_code,\n" +
                                        "    airport_name,\n" +
                                        "    city,\n" +
                                        "    coordinates,\n" +
                                        "    timezone\n" +
                                        "FROM\n" +
                                        "    bookings.airports\n" +
                                        "WHERE\n" +
                                        "    airport_code='" + code + "';"
                        );
        ) {
            return getAirPortsList(resultSet);
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


    private List<AirPortDto> getAirPortsList(ResultSet resultSet) throws SQLException {
        List<AirPortDto> airPortsListDto = new ArrayList<>();
        while(resultSet.next()){
            airPortsListDto.add(new AirPortDto(
                    resultSet.getString("airport_code"),
                    resultSet.getString("airport_name"),
                    resultSet.getString("city"),
                    resultSet.getString("coordinates"),
                    resultSet.getString("timezone")
            ));
        }
        return airPortsListDto;
    }

    @Override
    public void close() throws Exception {

    }
}
