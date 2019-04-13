/**
 * Class Pilot
 * 
 * Purpose:
 * 
 * To create Object Pilot with the following characteristics:
 * 
 * int ID
 * String name
 * String license
 * 
 * The characteristics ID and name are obtained by extending the super class Staff.
 */
package cctair.staff;

import java.util.ArrayList;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */
public class Pilot extends Staff { 
    /**
     * Pilot Licenses can vary as follow 
     * License A: Senior Pilot allow to fly any Airplane. 
     * License B: Allow to fly Airbus and Bombardier
     * License C: Allow to fly only Bombardier
    */
    private String license; 
    
    /**
     * Standard constructor for the case where a plane has no copilot assigned
     * 
     * it does not take any parameters
     */
    public Pilot() {
        super("NO COPILOT ASSINGED");
        this.license = "NA";
    }
    
    /**
     * Constructor to create a Object Pilot
     * 
     * It take the parameters:
     * 
     * @param name String name of the pilot
     * @param license String license of the pilot
     */
    public Pilot(String name, String license) {
        super(name); 
        this.license = license; 
    }
    
    /**
     * This method returns the license of the pilot
     * 
     * @return returns string license of the pilot
     */
    public String getLicense() {
        return license;
    }
    
    /**
     * toString method to tell the print statement how to print a Object Pilot
     *
     * @return formatted String of the Object Pilot
     */
    @Override
    public String toString(){
        return getName() + " --- Pilot License: " + getLicense(); 
    }

    public void setLicense(String license) {
        this.license = license;
    }
   
    
}
