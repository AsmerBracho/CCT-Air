/**
 * Class Airplane
 * 
 * Purpose:
 * 
 * Class that allows us to create airplanes Objects to be used in our system
 * This class create objects with the following characteristics:
 * 
 * int planeId
 * String make
 * int model
 * int capacity
 * Pilot pilot
 * pilot coPilot
 * String licenseRequired
 * 
 * This class implements the Interface InterfaceAirPlane
 */
package cctair.plane;
import cctair.staff.Pilot;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */

public class AirPlane implements InterfaceAirPlane {
    private static int id;
    private final int planeId; // Airplane ID
    private String make; // Airplane Make (e.i. Boeing, Airbus, etc)
    private int model; // Airplane Model (e.i 707, 737, 380 etc)
    private int capacity; // seats availables 
    private Pilot pilot; // Captain 
    private Pilot coPilot; // Copilot
    private String licenseRequired; // License required to flight airplane
    
    /**
     * This is the main constructor for the airplanes
     * 
     * It takes the parameters:
     * 
     * @param make make of the airplane
     * @param model model of the airplane
     * @param capacity capacity in seats of the airplane
     * @param pilot First pilot of the airplane
     */
    public AirPlane(String make, int model, int capacity, Pilot pilot) {
        planeId = id; 
        id++; 
        //Initialize the variables 
        this.make = make; 
        this.model = model; 
        this.capacity = capacity; 
        this.pilot = pilot;
        licenseRequired();
        // Initialize the coPilot objet with the null constructor given in the Pilot class
        this.coPilot = new Pilot();
    }
    
    /**
     * This is a complementary constructor we have created for the airplane class.
     * IT is used when we want to create an airplane with first pilot and copilot at the same time
     * 
     * It takes the parameters:
     * 
     * @param make make of the airplane
     * @param model model of the airplane
     * @param capacity capacity of the airplanes is seats
     * @param pilot First pilot of the airplane
     * @param coPilot Copilot of the airplane
     */
    public AirPlane(String make, int model, int capacity, Pilot pilot, Pilot coPilot) {
        planeId = id; 
        id++;
        this.make = make; 
        this.model = model; 
        this.capacity = capacity; 
        this.pilot = pilot;
        this.coPilot = coPilot;
        licenseRequired();
    }
    
    /**
     * This method returns the ID of the airplane
     * 
     * @return returns integer ID of the airplane
     */
    @Override
    public int getPlaneId() {
        return planeId;
    }
    
    /**
     * This method returns the make of the airplane
     * 
     * @return returns string make of the airplane
     */
    @Override
    public String getMake() {
        return make; 
    }

    /**
     * This method returns the model of the airplane
     * 
     * @return returns integer model of the airplane
     */
    @Override
    public int getModel() {
       return model; 
    }

    /**
     * This method returns the pilot of the airplane
     * 
     * @return returns Object Pilot of the airplane
     */
    @Override
    public Pilot getPilot() {
        return pilot; 
    }
    
    /**
     * This method returns the copilot of the airplane
     * 
     * @return returns Object Pilot of the airplane
     */
    public Pilot getCoPilot() {
        return coPilot;
    }
    
    /**
     * This method returns the capacity in seats of the airplane
     * 
     * @return returns integer capacity of the airplane
     */
    @Override
    public int capacity() {
        return capacity; 
    }
    
    /**
     * This method assigns the first pilot to the aircraft
     * 
     * It takes the parameters:
     * 
     * @param pilot is an Object Pilot to assign the pilot to the airplane
     */
    @Override
    public void assignPilot(Pilot pilot) {
       this.pilot = pilot; 
    }
    
    /**
     * This method assigns the copilot to the aircraft
     * 
     * It takes the parameters:
     * 
     * @param coPilot is an Object Pilot to assign the copilot to the airplane
     */
    public void assignCoPilot(Pilot coPilot) {
        this.coPilot = coPilot; 
    }
    
    /**
     * This toString method is to tell the print statement how to print a Object AirPlane
     * 
     * @return returns the formatted string to be printed by the command System.out.println(Object AirPlane)
     */
    @Override
    public String toString(){
        
        return "Airplane Information: \n\tAircraft: <<" + getMake() + ">> <<"
                + getModel() + ">>\n\tCapacity: " + capacity() + " seats"
                + "\n\tLicense Required: " + licenseRequired + "\n\tFirst Pilot (Captain): " + getPilot()
                + "\n\tCoPilot: " + getCoPilot();
    }
    
    /**
     * This method is to assign the type of license that the aircraft requires.
     * This was subjectively chosen because we do not know for certain how this work.
     * We research which aircrafts is easier to flight and from there we set our criteria.
     */
    @Override
    public void licenseRequired(){
        if ("Boeing".equals(getMake())) {
            licenseRequired = "A";
        } else if ("Airbus".equals(getMake())) {
            licenseRequired = "B"; 
        } else if ("Bombardier".equals(getMake())) {
            licenseRequired = "C"; 
        } else { 
            licenseRequired = "To be Defined"; 
        }
        
    }
   
    
    
}
