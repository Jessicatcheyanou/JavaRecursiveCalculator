package ezoTechnicalAssessment.ui;

import ezoTechnicalAssessment.dto.*;

import java.util.*;

/**
 * The View(and it's helper classes) is responsible for all user interaction.
 * No other component is allowed to interact with the user.
 * The View cannot access the DAO
 * i.e it handles UI Logic
 */

public class CharView {

    private final UserIO io;
    final RecursiveCalculator recursiveCalculator = new RecursiveCalculator();

    public CharView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection(){
        io.print("Main Menu");
        io.print("1. List Calculations");
        io.print("2. Create New Calculation");
        io.print("3. Exit");

        return io.readInt("Please select from the above choices",1,3);
    }

    public CHAR getNewInfo(){
        int key = 0;
        io.print("WELCOME TO EZO'S AND JESSICA'S CALCULATOR PROGRAM.");
        String calculator = io.readString("Please enter your calculation:");
        String results = recursiveCalculator.calculateInput(calculator);

        CHAR calculate = new CHAR();

        calculate.setCalculator(results);

        return calculate;
    }

    public void displayCreateBanner(){
        io.print("===Create CALCULATION===");
    }

    public void displayCreateSuccessBanner(){
        io.readString("CALCULATION successfully created.Please hit enter to continue");
    }

    public void displayAllCharsBanner(){
        io.print("=== Display All CALCULATIONS ===");
    }

    public void displayCharList(List<CHAR> dvdList){
        dvdList.forEach(System.out::println);
        io.readString("Please hit enter to continue");
    }

    public void displayExitBanner(){
        io.print("Good Bye!");
    }

    public void displayUnknownCommandBanner(){
        io.print("Unknown Command");
    }

    public void displayErrorMessage(String errorMsg){
        io.print("===ERROR===");
        io.print(errorMsg);
    }

}
