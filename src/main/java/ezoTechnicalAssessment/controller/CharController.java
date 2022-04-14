package ezoTechnicalAssessment.controller;

import ezoTechnicalAssessment.dao.CharDaoException;
import ezoTechnicalAssessment.dao.CharDao;
import ezoTechnicalAssessment.dto.CHAR;
import ezoTechnicalAssessment.ui.CharView;

import java.text.ParseException;
import java.util.*;

/**
 * The controller is the brains of the application.That is
 * It knows;
 * What needs to be done
 * When it needs to be done AND
 * Who does the work.(in our case,the View and the DAO)
 * i.e it directs the work but never doing the work itself.
 * The View cannot access the DAO and
 * the DAO cannot access the View.
 *In this application,the Controller;
 * -Controls when the menu system is displayed
 * -
 */

public class CharController {

    private final CharDao dao;
    private final CharView view;

    public CharController(CharDao dao, CharView view) {
        this.dao = dao;
        this.view = view;
    }

    //Displays the menu
    public void run() throws ParseException{
        boolean keepGoing = true;
        int menuSelection;

        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1 -> listChars();
                    case 2 -> createChar();
                    case 3 -> keepGoing = false;
                    default -> unknownCommand();
                }

            }
            exitMessage();
        }catch (CharDaoException e){
            view.displayErrorMessage(e.getMessage());
        }


    }

    //Gets the user's menu choice and perform an action based on the user's menu choice
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

    //LIST OF POSSIBLE ACTIONS TO BE PERFORMED BASED ON USER'S MENU CHOICE
    private void createChar() throws ParseException, CharDaoException {
        view.displayCreateBanner();
        CHAR newChar = view.getNewInfo();
        dao.addChar(newChar);
        view.displayCreateSuccessBanner();

    }

    private void listChars() throws ParseException, CharDaoException {
        view.displayAllCharsBanner();
        List<CHAR> charList = dao.getAllChars();
        view.displayCharList(charList);
    }

    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }

    private void exitMessage(){
        view.displayExitBanner();
    }
}
