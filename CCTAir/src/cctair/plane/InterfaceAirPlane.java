/**
 * Interface InterfaceAirPlane
 * 
 * Purpose:
 *
 * To create a base between the three of us to create a software that will follow the characteristics set by the three of us.
 * This is our contract agreement of how we want the class of the Airplanes to do and look like.
 */
package cctair.plane;

import cctair.staff.Pilot;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */
public interface InterfaceAirPlane {
    public int getPlaneId();
    public String getMake();
    public int getModel();
    public void assignPilot(Pilot pilot);
    public Pilot getPilot();
    public int capacity();
    public void licenseRequired();
}
