package ezoTechnicalAssessment.controller;

import ezoTechnicalAssessment.dao.CharDaoException;
import ezoTechnicalAssessment.dao.CharDao;
import ezoTechnicalAssessment.dto.CHAR;
import ezoTechnicalAssessment.ui.CharView;

import java.text.ParseException;
import java.util.*;

public class CharController {

    private final CharDao dao;
    private final CharView view;

    public CharController(CharDao dao, CharView view) {
        this.dao = dao;
        this.view = view;
    }

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

    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

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
