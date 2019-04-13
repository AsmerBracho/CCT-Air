/**
 * Class Data
 * 
 * Purpose:
 * 
 * Given that we do not have a database from where to take this data we decided to hard code it
 * 
 * Here we create two methods to create an arraylist of Objects Pilot and other to crate and arraylist of Objects AirPlane.
 * 
 * This class is called in the main class to generate the arraylists of the data needed
 */
package cctair;

import cctair.plane.AirPlane;
import cctair.staff.*;
import java.util.ArrayList;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */
public class Data {
    
    /**
     * This method creates and returns an arraylist of Objects Pilot
     * 
     * @return returns ArrayList of Objects Pilot
     */
    public ArrayList<Pilot> createPilots() {
        ArrayList<Pilot> pilots = new ArrayList<Pilot>();
        pilots.add(new Pilot("Adolfo Munoz", "A")); //0
        pilots.add(new Pilot("Justin Thimberlan", "C")); //1
        pilots.add(new Pilot("Ismael Rivero", "B")); //2
        pilots.add(new Pilot("Julio Iglesias", "A")); //3
        pilots.add(new Pilot("Pastor Lopez", "C")); //4
        pilots.add(new Pilot("Daddy Yanqui", "C"));//5
        pilots.add(new Pilot("Enrique Iglesias", "A")); //6
        pilots.add(new Pilot("Ruben Blades", "A"));//7
        pilots.add(new Pilot("Clint Eastwood", "A")); //8
        pilots.add(new Pilot("Simon Diaz", "B")); //9
        
        return pilots;
    }
    
    /**
     * This method creates and return an arraylist of Obejcts AirPlane
     * 
     * It takes the parameters:
     * 
     * @param pilots Arraylist of Objects Pilot
     * 
     * @return returns arraylist of Objects AirPlane
     */
    public ArrayList<AirPlane> createAirplanes(ArrayList<Pilot> pilots) {
        ArrayList<AirPlane> airplanes = new ArrayList<AirPlane>();
        airplanes.add(new AirPlane("Boeing", 737, 215, pilots.get(0)));
        airplanes.add(new AirPlane("Airbus", 318, 132, pilots.get(2)));
        airplanes.add(new AirPlane("Boeing", 777, 396, pilots.get(8)));
        airplanes.add(new AirPlane("Bombardier", 700, 68, pilots.get(1)));
        airplanes.add(new AirPlane("Boeing", 737, 215, pilots.get(7)));
        airplanes.add(new AirPlane("Airbus", 320, 220, pilots.get(6)));
        airplanes.add(new AirPlane("Bombardier", 100, 133, pilots.get(5)));
        
        return airplanes;
    }   
    
}
