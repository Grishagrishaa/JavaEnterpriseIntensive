package org.example.JavaEnterpriseIntensive.belavia.main;

import org.example.JavaEnterpriseIntensive.belavia.dto.AirPortDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String args[]) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("CHECK DRIVER PATH", e);
        }
        AirPortDto airPortDto = null;
        List<AirPortDto> airPortDtos = new ArrayList<>();
        try(
                Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/demo",
                "postgres",
                "postgres"
                );

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
                                "    city NOT IN ('Сочи', 'Краснодар')\n" +
                                "LIMIT 100;\n" +
                                "\n"
                        );

                ){


            while(resultSet.next()){
                airPortDtos.add(airPortDto = new AirPortDto(
                        resultSet.getString("airport_code"),
                        resultSet.getString("airport_name"),
                        resultSet.getString("city"),
                        resultSet.getString("coordinates"),
                        resultSet.getString("timezone")
                ));



            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(airPortDtos);
    }
}
