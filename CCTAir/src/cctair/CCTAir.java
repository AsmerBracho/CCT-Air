/**
 * Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 * Object Oriented Constructs - Group B
 * Application Development Project - Airplane
 * Last Modified 31/03/2018
 * 
 * Purpose:
 * 
 * Create a Schedule system for an airline to manage flights, pilots and airplanes
 * 
 * A menu was created to allow the user to interact with the system although first we performed the operations mentioned in the briefing of the project
 * 
 * [A] Declare and initialize a number of flights.
 * [B] Add up to 5 flights of your choice.
 * [C] Use the second version of the schedule method to set the time schedule for a flight.
 * [D] Use the first version of the schedule method to update the arrival time for a flight in the list.
 * [E] Display all flights.
 * 
 * Assumptions:
 * 
 * We are creating the data of pilots and airplanes in a method call Data that will call generate arraylists of this objects.
 * The we are creating 5 flights of our choice with this data. Given that we are not working with data base we decided to do hard code pilots and airplanes.
 * 
 */
package cctair;

import cctair.flight.Flight;
import cctair.staff.Pilot;
import cctair.menu.Menu; 
import cctair.plane.AirPlane;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */
public class CCTAir {

    /**
     * Main method of our program
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        
        Data data = new Data(); // Instatiating the class Data to be able to generate our pilots and airplanes
        ArrayList<Pilot> pilots = new ArrayList<Pilot>(); // Creating an ArrayList of Objects Pilot
        pilots = data.createPilots(); // Filling the arraylist with pilots
        ArrayList<AirPlane> airplanes = new ArrayList<AirPlane>(); // Creating an ArrayList of Obejcts AirPlanes
        airplanes = data.createAirplanes(pilots); // Filling the array with airplanes
        
        ArrayList<Flight> flights = new ArrayList<Flight>(); // Creating an ArrayList of Obejcts Flight
        
        
        // Adding the 5 flights to our system.
        flights.add(new Flight("Dublin", "London", "10/05/2018", airplanes.get(0)));
        flights.add(new Flight("France", "Madrid", "23/06/2018", airplanes.get(3)));
        flights.add(new Flight("Caracas", "Paris", "14/07/2018", airplanes.get(5)));
        flights.add(new Flight("Brussels", "Berlin", "30/04/2018", airplanes.get(2)));
        flights.add(new Flight("Dublin", "Moscow", "20/03/2018", airplanes.get(1)));
        
        // Second version of the Schedule method to set the schedule for a flight
        flights.get(4).schedule("15:00", "10:00");
        
        // First version of the Schedule method to update the arrival time for a flight.
        // The logical thing to do here is to update the arrival time for the flight before.
        // But to show that the method works we are goign to do it for any flight.
        flights.get(3).schedule("19:17");
        
        // Display all flights
        // Here we are using our class Menu to perform this for us so when you finish looking at the flights
        // you can experience our system.
        Menu menu = new Menu(pilots, airplanes, flights);
        menu.deleteMenu();
        menu.cabecera("All Flights");
        menu.subDisplayAllFlights();
        menu.mainMenu();
        //menu.mainMenu();

    }
    
}
