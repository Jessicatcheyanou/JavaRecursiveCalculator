package ezoTechnicalAssessment;

import ezoTechnicalAssessment.controller.CharController;
import ezoTechnicalAssessment.dao.*;
import ezoTechnicalAssessment.ui.*;

import java.text.ParseException;

public class App {

    public static void main(String[] args) throws ParseException{
        UserIO userIO = new UserIOConsoleImpl();
        CharView view = new CharView(userIO);
        CharDao dao = new CharDaoFileImpl();
        CharController controller = new CharController(dao,view);
        controller.run();
    }
}
