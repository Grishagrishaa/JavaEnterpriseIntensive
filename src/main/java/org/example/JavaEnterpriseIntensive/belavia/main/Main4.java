package org.example.JavaEnterpriseIntensive.belavia.main;

import org.example.JavaEnterpriseIntensive.belavia.dao.FlightsDao;
import org.example.JavaEnterpriseIntensive.belavia.dto.FlightsDto;

import java.time.LocalDateTime;
import java.util.List;

public class Main4 {
    public static void main(String[] args) throws Exception {
        FlightsDao serv = new FlightsDao();

        List<FlightsDto> all = serv.getAll();
        serv.close();

        for (FlightsDto flightsDto : all) {
            System.out.println(flightsDto);
        }
//        LocalDateTime now = LocalDateTime.now();
//        Thread.sleep(10000);
//        int second = now.getSecond();
//        System.out.println(LocalDateTime.now().getSecond() -  second);
    }
}
