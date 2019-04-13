/**
 * Class Flight
 *
 * Purpose:
 * 
 * To create Objects of type Flight to be use in our system.#
 * 
 * This class creates objects with the following characteristics:
 * 
 * int flightId
 * String origin
 * String destination
 * String departureTime
 * String arrivalTime
 * String dateOfFlight
 * AirPlane plane
 * 
 */
package cctair.flight;

import cctair.plane.AirPlane;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */
public class Flight implements InterfaceFlight {
    private static int id; 
    private final int flightId;
    private String origin;
    private String destination; 
    private String departureTime; 
    private String arrivalTime;
    private String dateOfFlight;
    private AirPlane plane; 
    
    /**
     * Constructor of the Class Flight to create objects Flight.
     * 
     * This constructor takes the parameters:
     * 
     * @param origin String origin of flight
     * @param destination String destination of flight
     * @param dateOfFlight String dateOfFlight of flight
     * @param plane Object AirPlane of flight
     */
    public Flight(String origin, String destination, String dateOfFlight, AirPlane plane) {
        flightId = id; 
        id++; 
        this.origin = origin; 
        this.destination = destination; 
        this.dateOfFlight = dateOfFlight;
        this.plane = plane;
        departureTime = "NOT AVAILABLE"; // Departure time is not assign when class is instatiated
        arrivalTime = "NOT AVAILABLE"; // Arrival time is not assign when class is instatiated
    }
    
    /**
     * Method used to modify the arrival time of the flight.
     * 
     * It take the parameters:
     * 
     * @param arrivalTime String arrival time of the flight
     */
    @Override
    public void schedule(String arrivalTime) {
        this.arrivalTime = arrivalTime; 
    }
    
    /**
     * This method is used to set the arrival time and departure time of the flight.
     * 
     * It take s the parameters:
     * 
     * @param arrivalTime String arrival time of the flight
     * @param departureTime String departure time of the flight
     */
    @Override
    public void schedule(String arrivalTime, String departureTime) {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime; 
    }

    /**
     * This method returns the origin of the flight.
     * 
     * @return returns String origin of the flight
     */
    @Override
    public String getOrigin() {
        return origin;
    }
    
    /**
     * This method returns the destination of the flight.
     * 
     * @return returns String destination of the flight
     */
    @Override
    public String getDestination() {
        return destination;
    }
    
    /**
     * This method returns the departure time of the flight
     * 
     * @return returns String departure time of the flight
     */
    @Override
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * This method returns the arrival time of the flight
     * 
     * @return returns String arrival time of the flight
     */
    @Override
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * This method returns the date of the flight
     * 
     * @return returns String date of the flight
     */
    @Override
    public String getDateOfFlight() {
        return dateOfFlight;
    }

    /**
     * This method returns the plane use for the specific flight
     * 
     * @return returns Object AirPlane assign for the flight
     */
    @Override
    public AirPlane getPlane() {
        return plane;
    }
    
    /**
     * toString method used to tell the print statement how to deal with Objects Flight
     * 
     * @return returns formatted string to print a Object Flight
     */
    @Override
    public String toString(){
        
        return "Fligh Information: \n\tDate: <<" + getDateOfFlight() + ">>"
                + "\n\tFrom: <<" +  getOrigin() + ">> to <<" + getDestination() + ">>" 
                + "\n\tFlight Time: <<" + getDepartureTime() + ">> to <<"
                + getArrivalTime() + ">>\n" + getPlane();
    }
    
}
