package org.example.JavaEnterpriseIntensive.belavia.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.example.JavaEnterpriseIntensive.belavia.dto.AirPortDto;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirPortPoolDao implements IAirPortDao {
    List<AirPortDto> airPortDtos;
    DataSource source;

    public AirPortPoolDao() {
        ComboPooledDataSource pool = new ComboPooledDataSource();
        try {
            pool.setDriverClass("org.posgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException("CHECK DRIVER PATH", e);
        }
        pool.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        pool.setUser("postgres");
        pool.setPassword("postgres");
        this.source = pool;
    }
//"ORDER BY " + "city" +
    public List<AirPortDto> getAll(){
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
                PreparedStatement statement = connection.prepareStatement("SELECT\n" +
                        "    airport_code,\n" +
                        "    airport_name,\n" +
                        "    city,\n" +
                        "    coordinates,\n" +
                        "    timezone\n" +
                        "FROM\n" +
                        "    bookings.airports\n" +
                        "WHERE\n" +
                        "    airport_code= + ? + ;");
                        )
         {
             statement.setString(1, code);
             ResultSet resultSet = statement.executeQuery();
            return getAirPortsList(resultSet);
        }
        catch (SQLException e) {}
        return null;
    }


    private Connection getConnnection() throws SQLException {
        return source.getConnection();
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
        DataSources.destroy(this.source);
    }
}
