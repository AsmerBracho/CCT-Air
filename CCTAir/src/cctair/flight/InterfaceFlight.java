/**
 * Interface InterfaceFlight
 * 
 * Purpose:
 * 
 * To create a base between the three of us to create a software that will follow the characteristics set by the three of us.
 * This is our contract agreement of how we want the class of the Flights to do and look like.
 */
package cctair.flight;

import cctair.plane.AirPlane;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */
public interface InterfaceFlight {
    public void schedule(String arrivalTime);
    public void schedule(String arrivalTime, String departureTime);
    public String getOrigin();
    public String getDestination();
    public String getDepartureTime();
    public String getArrivalTime();
    public String getDateOfFlight();
    public AirPlane getPlane();
}
