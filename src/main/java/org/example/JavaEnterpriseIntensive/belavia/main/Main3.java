package org.example.JavaEnterpriseIntensive.belavia.main;

import org.example.JavaEnterpriseIntensive.belavia.dto.AirPortDto;
import org.example.JavaEnterpriseIntensive.belavia.dao.AirPortPoolDao;
import org.example.JavaEnterpriseIntensive.belavia.dao.IAirPortDao;

import java.util.List;

public class Main3 {
    public static void main(String[] args) {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        try( IAirPortDao service = new AirPortDao();){
//            job(service);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        try(IAirPortDao service1 = new AirPortPoolDao();){
           job(service1);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }


    }
    private static void job(IAirPortDao service){
        long start = System.currentTimeMillis();
        List<AirPortDto> airPortDtos = service.getAll();
        long stop = System.currentTimeMillis();
        System.out.println(stop - start);
//        for (AirPort airPort : airPorts) {
//           System.out.println(airPort);
//        }

//        List<AirPort> airPort = service.get("GDX");
        start = System.currentTimeMillis();
        for (AirPortDto port : airPortDtos) {
            service.get(port.getAirport_code());
        }
        stop = System.currentTimeMillis();
        System.out.println(stop - start);
    }
}
