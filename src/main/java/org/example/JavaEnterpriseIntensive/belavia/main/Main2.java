package org.example.JavaEnterpriseIntensive.belavia.main;

import org.example.JavaEnterpriseIntensive.belavia.dto.AirPortDto;
import org.example.JavaEnterpriseIntensive.belavia.dao.AirPortDao;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try( AirPortDao service = new AirPortDao();){
            List<AirPortDto> airPortDto = service.get("GDX");
            for (AirPortDto port : airPortDto) {
                System.out.println(port);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



//        List<AirPort> airPorts = service.getAll();
//        for (AirPort airPort : airPorts) {
//            System.out.println(airPort);
//        }

    }
}
