/**
 * Interface InterfaceMenu
 * 
 * Purpose:
 *
 * To create a base between the three of us to create a software that will follow the characteristics set by the three of us.
 * This is our contract agreement of how we want the class of the Menu to do and look like.
 * 
 */
package cctair.menu;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */
public interface InterfaceMenu {
    public void cabecera(String s);
    public void mainMenu();
    public void menuFlights();
    public void subDisplayAllFlights();
    public void updateFlight();
    public void updateFlightsPilot(String type);
    public void updateSchedule();
    public void updateArrival();
    public void menuAirplanes();   
    public void menuPilots(); 
    public void goBack(int where);
    public void deleteMenu();
    public void showFlightsSimplified();
    public void showPilotsSimplified();
    public String updateTime(String type);
    public boolean validateTime(String time);
}
