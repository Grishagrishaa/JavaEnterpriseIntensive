package org.example.JavaEnterpriseIntensive.belavia.dto;

public class FlightsDto {
    private int flight_id;
    private String flight_no;
    private String scheduled_departure;
    private String scheduled_arrival;
    private String departure_airport;
    private String arrival_airport;
    private String status;
    private String aircraft_code;
    private String actual_departure;
    private String actual_arrival;

    public FlightsDto(int flight_id, String flight_no,
                      String scheduled_departure, String scheduled_arrival,
                      String departure_airport, String arrival_airport,
                      String status, String aircraft_code,
                      String actual_departure, String actual_arrival)
    {
        this.flight_id = flight_id;
        this.flight_no = flight_no;
        this.scheduled_departure = scheduled_departure;
        this.scheduled_arrival = scheduled_arrival;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
        this.status = status;
        this.aircraft_code = aircraft_code;
        this.actual_departure = actual_departure;
        this.actual_arrival = actual_arrival;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public String getFlight_no() {
        return flight_no;
    }

    public String getScheduled_departure() {
        return scheduled_departure;
    }

    public String getScheduled_arrival() {
        return scheduled_arrival;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public String getStatus() {
        return status;
    }

    public String getAircraft_code() {
        return aircraft_code;
    }

    public String getActual_departure() {
        return actual_departure;
    }

    public String getActual_arrival() {
        return actual_arrival;
    }

    @Override
    public String toString() {
        return '\n' +"FlightsDto{" +
                "flight_id='" + flight_id + '\'' +
                ", flight_no='" + flight_no + '\'' +
                ", scheduled_departure='" + scheduled_departure + '\'' +
                ", scheduled_arrival='" + scheduled_arrival + '\'' +
                ", departure_airport='" + departure_airport + '\'' +
                ", arrival_airport='" + arrival_airport + '\'' +
                ", status='" + status + '\'' +
                ", aircraft_code='" + aircraft_code + '\'' +
                ", actual_departure='" + actual_departure + '\'' +
                ", actual_arrival='" + actual_arrival + '\'' +
                '}';
    }
}
