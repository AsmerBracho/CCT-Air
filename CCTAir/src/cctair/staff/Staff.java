/**
 * Class Staff
 * 
 * Purpose:
 * 
 * This class is focused to be the parent class for all kind of employees that this Airline Company might have
 * For our case we are only using pilots but we can have others kind such as flight attendant, chefs, etc.
 * 
 * This class will create an object with the following characteristics:
 * 
 * int staffId
 * String name
 * 
 */
package cctair.staff;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */
public class Staff {
    private static int id; 
    private final int staffId; // ID of the Staff member
    private String name; // NAme of the staff member
    
    /**
     * Main constructor of the Staff class
     * 
     * It takes the parameters:
     *
     * @param name string name of the staff
     */
    public Staff(String name) {
        this.name = name;
        staffId = id; 
        id++;
    }

    /**
     * This method Returns the staff ID number
     * 
     * @return returns integer staff ID number
     */
    public int getStaffId() {
        return staffId;
    }
    
    /**
     * This method Returns the staff name
     * 
     * @return returns String name of the staff
     */
    public String getName() {
        return name;
    }
    
    
}
