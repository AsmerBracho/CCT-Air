/**
 * Class Menu
 * 
 * Purpose:
 * 
 * Create a menu and sub menus to achieve an interactive way of operating a schedule system of an example airline
 * Here, we are creating a main menu to access to different options such as flights, airplanes and pilots.
 * Inside airplanes and pilots we can see the airplanes and pilots that we have in the system (hard code values)
 * But we cannot edit them.
 * 
 * In flight we can see all flight plus we can change pilot and copilot of the aircraft and the schedule times.
 * 
 * Assumptions:
 * 
 * We are seeing this as a real world example in which you assign the pilot to the flight and not to an specific aircraft
 * 
 * This class is implementing a interface called InterfaceMenu
 * 
 */
package cctair.menu;

import cctair.flight.Flight;
import cctair.plane.AirPlane;
import java.util.Scanner;
import cctair.staff.Pilot;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Adelo Vieira (2017276), Asmer Bracho (2016328) and Miguelantonio Guerra (2016324)
 */
public class Menu implements InterfaceMenu {
    ArrayList<Pilot> pilot = null;          /** Array list of pilots in our system */
    ArrayList<AirPlane> airplanes = null;   /** Array list of planes in out system */
    ArrayList<Flight> flights = null;       /** Array list of flights in our system */
    
    /**
     * Constructor for the menu of our System.
     * 
     * It takes the parameters:
     * 
     * @param p an array list of pilots
     * @param a an array list of airplanes
     * @param f an array list of flights
     * 
     */
    public Menu(ArrayList<Pilot> p, ArrayList<AirPlane> a, ArrayList<Flight> f) {
        this.pilot = p; 
        this.airplanes = a;
        this.flights = f; 
    }
    
    /**
     * This method prints a header for every menu and sub-menu in our system
     * The word cabecera means header in Spanish
     * 
     * It takes the parameter:
     * 
     * @param s a String that shows the user in which menu or sub-menu we are
     */
    @Override
    public void cabecera(String s) {
        deleteMenu(); // Clear previous menu
        int lenValue = s.length(); // Length of the word that describes the menu we are on
        StringBuffer varSpace = new StringBuffer(); // Variable String to center the Menu string
        for (int i = 0; i < (72-lenValue)/2; i++) {
            varSpace.append(" ");
        }
        
        System.out.println("                            _________________________________");
        System.out.println("          ___             /| ##### ##### #####   #   # ####  |");
        System.out.println("          \\  \\     _ _   / | #     #       #    # #  # #   # |");
        System.out.println("           \\**\\ ___\\/ \\<   | #     #       #   ##### # ####  |");
        System.out.println("         X*#####*+^^\\_\\  \\ | #     #       #   #   # # #  #  |");
        System.out.println("           o/\\  \\         \\| ##### #####   #   #   # # #   # |");
        System.out.println("              \\__\\          ----------------------------------");
        System.out.println();
        System.out.println("========================================================================");
        System.out.println(varSpace + "\033[35m" + s);
        System.out.println("========================================================================");
           
    }
    
    /**
     * This Method creates the Main Menu for our Schedule System
     * This menu gives us the options:
     * 
     * [1] Flights
     * [2] Airplanes
     * [3] Pilots
     * [4] exit
     */
    @Override
    public void  mainMenu() {
        cabecera("Main Menu");
        System.out.println("Welcome to the CCT Airline Schedule System");
        
        String selection =null; // Variable to record the selection of the user
           
        do {
            System.out.println("Please Select an Option\n");
            System.out.println("[1] Flight\n[2] Airplanes\n[3] Pilot\n[4] Exit\n");

            System.out.print("Insert selection: "); 
            Scanner sc = new Scanner(System.in);
            selection = sc.nextLine();

            switch (selection) {
                case "1": menuFlights(); break;
                case "2": menuAirplanes(); break;
                case "3": menuPilots(); break;
                case "4": System.out.println("Application has been shut down"); break;
                default: System.out.println("The selection was invaild!");
            }
        } while (!"4".equals(selection));
    }
    
    /**
     * This Method creates a menu to manage the flights in the system
     * This menu gives us the options:
     * 
     * [1] Display all Flights
     * [2] Update Flights
     * [3] Go Back
     */
    @Override
    public void menuFlights() {
       
        cabecera("Flights");
        System.out.println("In this Section you can Manage your Flights");
        
        String selection =null; // String to record the selection of the user
           
        do {
            System.out.println("Please Select an Option\n");
            System.out.println("[1] Display All Flights\n[2] Update Flight\n[3] Go Back\n");

            System.out.print("Insert selection: "); 
            Scanner sc = new Scanner(System.in);
            selection = sc.nextLine();

            switch (selection) {
                case "1": subDisplayAllFlights(); break;
                case "2": updateFlight(); break;
                case "3": cabecera("Main Menu"); break;
                default: System.out.println("The selection was invaild!");
            }
        } while (!"3".equals(selection));
        
    }
    
    /**
     * The method shows you all the airplanes that are "stored" in our system
     * It gives us only one option
     * 
     * [1] Go Back
     */
    @Override
    public void subDisplayAllFlights() {
        String selection = null; // String to record the user selection
        cabecera("All Flights"); 
        System.out.println();
        for (int i = 0; i < flights.size(); i++) {
            System.out.println(flights.get(i));
            System.out.println("------------------------------------------------------------------------\n");
        }
        goBack(2);
    }
    
    /**
     * This Method creates a Sub-menu to update the Flights.
     * This Sub-menu gives us the options:
     * [1] Update Pilot.
     * [2] Update Copilot.
     * [3] Update Schedule (Departure and Arrival times).
     * [4] Update Arrival time.
     * [5] Go Back.
     * 
     * Only the flights that have been created in the MAIN are going to be updated.
     */
    @Override
    public void updateFlight(){
        
        cabecera("Update Flights");
        System.out.println("In this Section you can update flights");
        
        String selection =null; // String to recover the users input
           
        do {
            System.out.println("Please Select an Option\n");
            System.out.print("[1] Update Pilot\n[2] Update Copilot\n");
            System.out.print("[3] Update Schedule (Departure and Arrival times)\n");
            System.out.println("[4] Update Arrival time\n\n[5] Go Back\n");

            System.out.print("Insert selection: "); 
            Scanner sc = new Scanner(System.in);
            selection = sc.nextLine();

            switch (selection) {
                case "1": updateFlightsPilot("Pilot"); break;
                case "2": updateFlightsPilot("Copilot"); break;
                case "3": updateSchedule(); break;
                case "4": updateArrival(); break;
                case "5": cabecera("Flights"); break;
                default: System.out.println("The selection was invaild!");
            }
        } while (!"5".equals(selection));
        
    }
    
    /**
     * This method changes the Flight's pilot and copilot
     * 
     * This method shows you, first, the flights in a simplified version and after choosing flight it shows you the pilots
     * Not all pilots can be the first pilot of the aircraft (depending of the license) but all pilots can be copilot
     * 
     * It takes the parameter:
     * 
     * @param type this indicates the type of pilot to update, either Pilot or Copilot
     */
    @Override
    public void updateFlightsPilot(String type) {
        
        cabecera("Update " + type);
        System.out.println("\nChoose the Flight you want to add a " + type + " to\n");
        
        int selectFlight = 0 ; // Index of the flight selected
        int selectPilot = 0; // Index of the pilot selected
        boolean chosenFlight = false; // Variable of control to know if the flight has been selected
        boolean chosenPilot = true; // Variable of control to know if the pilot has been selected
        boolean flightUpdated = false; // Variable of control to know if the flight has been updated
        
        showFlightsSimplified();
        System.out.println("\n[0] Cancel\n");
        
        /** Check if the flight was selected */
        while (chosenFlight == false) {
            
            System.out.print("Insert selection: ");
            Scanner sc = new Scanner(System.in);
            try {
                selectFlight = Integer.parseInt(sc.nextLine());
                
                if (selectFlight == 0) {
                    cabecera("Update Flight");
                    chosenFlight = true;
                } else if ((selectFlight < 0)||(selectFlight > flights.size())) {
                    System.out.println("The selection was invaild!");
                } else {
                    chosenFlight = true;
                    chosenPilot = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("The selection was invaild!");
            }
            
        }
        
        if ((chosenFlight == true)&&(chosenPilot == false)) {
            System.out.println("\nChoose the " + type + " for the chosen flight\n");
            showPilotsSimplified();
            System.out.println("\n[0] Cancel\n");
        }
        
        /** Check if the pilot was selected */
        while (chosenPilot == false) {
            
            System.out.print("Insert selection: ");
            Scanner sc = new Scanner(System.in);
            
            try {
                selectPilot = Integer.parseInt(sc.nextLine());
                if (selectPilot == 0) {
                    cabecera("Update Flight");
                    chosenPilot = true;
                } else if ((selectPilot < 0)||(selectPilot > pilot.size())) {
                    System.out.println("The selection was invaild!");
                } else if (("Pilot".equals(type))&&("Boeing".equals(flights.get(selectFlight-1).getPlane().getMake()))&&(("B".equals(pilot.get(selectPilot-1).getLicense()))||("C".equals(pilot.get(selectPilot-1).getLicense())))) {
                    System.out.println("This pilot is not allowed to be the first pilot of this aircraft");
                } else if (("Pilot".equals(type))&&("Airbus".equals(flights.get(selectFlight-1).getPlane().getMake()))&&("C".equals(pilot.get(selectPilot-1).getLicense()))) {
                    System.out.println("This pilot is not allowed to be the first pilot of this aircraft");
                } else {
                    chosenPilot = true;
                    flightUpdated = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("The selection was invaild!");
            }
            
        }
        
        /** After all is done performs the operations to update the system */
        if (flightUpdated == true) {
            System.out.print("\nThe pilot " + pilot.get(selectPilot-1).getName() + " has been assigned ");
            System.out.print("as the " + type + " of the flight from " + flights.get(selectFlight-1).getOrigin());
            System.out.print(" to " + flights.get(selectFlight-1).getDestination() + " on the ");
            System.out.println(flights.get(selectFlight-1).getDateOfFlight());
            
            if ("Pilot".equals(type)) {
                flights.get(selectFlight-1).getPlane().assignPilot(pilot.get(selectPilot-1));
                airplanes.get(airplanes.indexOf(flights.get(selectFlight-1).getPlane())).assignPilot(pilot.get(selectPilot-1));
            } else {
                flights.get(selectFlight-1).getPlane().assignCoPilot(pilot.get(selectPilot-1));
                airplanes.get(airplanes.indexOf(flights.get(selectFlight-1).getPlane())).assignCoPilot(pilot.get(selectPilot-1));
            }
            
            goBack(3);
        }
        
        
    }

    /**
     * This method updates the Schedule of the flight, in other words The Departure and The Arrival Time.
     * 
     * There is no mandatory condition in this case, because we can update both, the departure and the arrival at any time
     */
    @Override
    public void updateSchedule() {
        
        boolean chosenFlight = false; // Check if the flight was chosen
        boolean chosenDeparture = true; // Check if the departure time was set
        boolean chosenArrival = true; // Checck if the arrival time was set
        int selectFlight = 0; // Stores the flight index
        String arrival = ""; // String that stores the flight's arrival time
        String departure = ""; // String that stores the flight's departure time
        
        cabecera("Update Schedule (Departure time and Arrival time)");
        System.out.println("\nChoose the Flight you want to set the Departure and Arrival time");
        
        showFlightsSimplified();
        System.out.println("\n[0] Cancel\n");
        
        /** First we choose the flight */
        while (chosenFlight == false) {
            
            System.out.print("Insert selection: ");
            Scanner sc = new Scanner(System.in);
            
            try {
                selectFlight = Integer.parseInt(sc.nextLine());
                if (selectFlight == 0) {
                    cabecera("Update Flight");
                    chosenFlight = true;
                } else if ((selectFlight < 0)||(selectFlight > flights.size())) {
                    System.out.println("The selection was invaild!");
                } else {
                    chosenFlight = true;
                    chosenDeparture = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("The selection was invaild!");
            }
            
        }
        
        /** Then we set the departure time */
        if ((chosenFlight == true)&&(chosenDeparture == false)) {
            System.out.println("\nChoose the Departure time for the flight you have selected");        
            System.out.println("\n[0] Cancel\n");
            departure = updateTime("Departure");
            if ((!departure.equals(""))&&(!"0".equals(departure))) {
                chosenDeparture = true;
                chosenArrival = false;
            } else {
                deleteMenu();
                cabecera("Update Flight");
            }
        }
        
        /** Finally we set the arrival time and update the system */
        /** Here we are using a delay of 5 seconds to redirect the user to the Update Flight after everything is done */
        if ((chosenArrival == false)&&(chosenDeparture == true)) {
            System.out.println("\nChoose the Arrival time for the flight you have selected");        
            System.out.println("\n[0] Cancel\n");
            arrival = updateTime("Arrival");
            if ((!arrival.equals(""))&&(!"0".equals(arrival))) {
                flights.get(selectFlight-1).schedule(arrival, departure);
                try {
                    System.out.print("\nSchedule for the flight from " + flights.get(selectFlight-1).getOrigin());
                    System.out.print(" to " + flights.get(selectFlight-1).getDestination());
                    System.out.print(" on the " + flights.get(selectFlight-1).getDateOfFlight());
                    System.out.println(" has been updated\n");
                    System.out.println("\nYou are going to be redirected to the Update Flight menu in 5 seconds");
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                deleteMenu();
                cabecera("Update Flight");
            } else {
                deleteMenu();
                cabecera("Update Flight");
            }
        }
        
    }

    /**
     * This method updates the Arrival time of the flight.
     * 
     * Here, it is mandatory to have the Schedule set to be able to change/update the arrival time of the flight
     *
     * This Method can be absorbed by the updateSchedule() method by passing a control parameter to tell the computer what to do.
     * For the scope of this project we are going to work it separately.
     */
    @Override
    public void updateArrival() {
        
        boolean chosenFlight = false; // Check if the flight was selected
        boolean chosenArrival = true; // Check if the arrival time was set
        int selectFlight = 0; // Stores the index of the selected flight
        String arrival = ""; // Stores the arrival time
        
        cabecera("Update Arrival time");
        System.out.println("\nChoose the Flight you want to set the Arrival time");
        
        showFlightsSimplified();
        System.out.println("\n[0] Cancel\n");
        
        /** Here we select the flight that has a set Schedule */
        while (chosenFlight == false) {
            
            System.out.print("Insert selection: ");
            Scanner sc = new Scanner(System.in);
            
            try {
                selectFlight = Integer.parseInt(sc.nextLine());
                if (selectFlight == 0) {
                    cabecera("Update Flight");
                    chosenFlight = true;
                } else if ((selectFlight < 0)||(selectFlight > flights.size())) {
                    System.out.println("The selection was invaild!");
                } else if (flights.get(selectFlight-1).getArrivalTime().equals("NOT AVAILABLE")) {
                    System.out.println("Arrival time cannot be set for this flight because it does not have schedule set");
                } else {
                    chosenFlight = true;
                    chosenArrival = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("The selection was invaild!");
            }
            
        }
        
        /** Finally we set the arrival time and update the system */
        /** Here we are using a delay of 5 seconds to redirect the user to the Update Flight after everything is done */
        if ((chosenFlight == true)&&(chosenArrival == false)) {
            System.out.println("\nChoose the Arrival time for the flight you have selected");        
            System.out.println("\n[0] Cancel\n");
            arrival = updateTime("Arrival");
            if ((!arrival.equals(""))&&(!"0".equals(arrival))) {
                flights.get(selectFlight-1).schedule(arrival);
                try {
                    System.out.print("\nArrival time for the flight from " + flights.get(selectFlight-1).getOrigin());
                    System.out.print(" to " + flights.get(selectFlight-1).getDestination());
                    System.out.print(" on the " + flights.get(selectFlight-1).getDateOfFlight());
                    System.out.println(" has been updated\n");
                    System.out.println("\nYou are going to be redirected to the Update Flight menu in 5 seconds");
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                deleteMenu();
                cabecera("Update Flight");
            } else {
                deleteMenu();
                cabecera("Update Flight");
            }
        }
    }
    
    /**
     * This Method shows us the airplanes that we have in our system.
     * 
     * It only waits for the user to tell him to go back
     */
    @Override
    public void menuAirplanes() {
        String selection = null; // Selection of the user
        cabecera("Airplanes"); 
        System.out.println();
        /** Priting the airplanes */
        for (int i = 0; i < airplanes.size(); i++) {
            System.out.println(airplanes.get(i));
            System.out.println("------------------------------------------------------------------------\n");
        }
        goBack(1);
    }
    
    /**
     * This method shows us the pilots that we have in our system.
     * 
     * It only waits for the user to tell him to go back.
     */
    @Override
    public void menuPilots() { 
        cabecera("Pilots"); 
        System.out.println();
        showPilotsSimplified();
        goBack(1);
        
    }
    
    /**
     * Since we use the option to "Go Back" several times throughout our code we have created this method
     * 
     * This method gives the option to "Go Back" to the previous menu depending in which sub-menu we are on
     * 
     * It takes a parameter:
     * 
     * @param where that indicates in which menu we call this method
     */
    @Override
    public void goBack(int where) {
        String selection = null; // User selection
        do {
            System.out.println("\n[1] Go Back\n");
            System.out.print("Insert selection: "); 
            Scanner sc = new Scanner(System.in);
            selection = sc.nextLine();
            switch (selection) {
                case "1":
                    if (where==1) { 
                        cabecera("Main Menu");
                        break;
                    } else if(where == 3) {
                        cabecera("Update Flights");
                    } else {
                        cabecera("Flights");
                    break;
                    }
                    
                default: System.out.println("The selection was invalid!");
            }
        } while (!"1".equals(selection));
    }
    
    /**
     * This method uses the Robot class to create an instance of it to simulate key strokes.
     * 
     * This key strokes are use to focus the output window of neat beans (Ctrl+4) and to clean it whenever a new menu is opened (Ctrl+L)
     * 
     * This Robot is quite unstable so, we have to play with the delay time to make it work properly. We are eager to ask you about this class and comment about its problems.
     */
    @Override
    public void deleteMenu() {
        try {
        // Simulate a key press
        Robot robot = new Robot();        
    
        robot.delay(20);
        robot.keyRelease(KeyEvent.VK_4);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(20);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_4);
        robot.delay(20);
        robot.keyRelease(KeyEvent.VK_4);
        robot.delay(20);
        robot.keyPress(KeyEvent.VK_L);
        robot.delay(20);
        robot.keyRelease(KeyEvent.VK_L);
        robot.delay(20);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(20);
        } catch (AWTException ex) {}
    }
    
    /**
     * This method prints a simplified version of the flights for practical purposes.
     * 
     * The flights are printed as follows:
     * 
     * [index+1] from: Origin to: Destination date: DateOfFlight
     */
    @Override
    public void showFlightsSimplified() {
        for (int i = 0; i < flights.size(); i++) {
                System.out.print("[" + (i+1) + "] ");
                System.out.print("from: " + flights.get(i).getOrigin() + " -- ");
                System.out.print("to: " + flights.get(i).getDestination() + " -- ");
                System.out.println("date: " + flights.get(i).getDateOfFlight());
        }
        
        System.out.println();
    }
    
    /**
     * This method prints a simplified version of the pilots for practical purposes.
     * 
     * The Pilots are printed as follows:
     * 
     * [index+1] PilotsName License: PilotsLicense
     */
    @Override
    public void showPilotsSimplified() {
        for (int i = 0; i < pilot.size(); i++) {
            System.out.println("[" + (i+1) + "] " + pilot.get(i).getName() + "  License: " + pilot.get(i).getLicense());
        }
        System.out.println();
    }
    
    /**
     * This method validates time inputs and returns this time input whenever the user does it properly
     * 
     * it takes the parameter:
     * 
     * @param type to check what time it is being updated, arrival or departure
     * @return returns the departure or arrival time, depending on the type parameter
     */
    @Override
    public String updateTime(String type) {
        
        String selection = null;
           
        do {
            System.out.println("Enter new time");
            System.out.println("\nFormat: hh:mm\n");

            System.out.print("Insert selection: "); 
            
            Scanner sc = new Scanner(System.in);
            selection = sc.nextLine();
            
            if ((validateTime(selection) == false)&&(!"0".equals(selection))){
                System.out.println("\nWrong time format, try again!\n");
            } else if (!"0".equals(selection)) {
                System.out.println(type + " time has been updated");
            }
            
        } while ((validateTime(selection) == false)&&(!"0".equals(selection)));
                
        return selection;
    }
    
    /**
     * This method is the responsible for the validation side of the previous method, updateTime(String type).
     * 
     * It takes the parameters:
     * 
     * @param time the input time to validate
     * @return to say to the user whether or not the time input was right or not
     */
    @Override
    public boolean validateTime(String time) {
        
        String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern pattern = Pattern.compile(TIME24HOURS_PATTERN);
        
        Matcher matcher = pattern.matcher(time);

        return matcher.matches();
        
    }

}
    

