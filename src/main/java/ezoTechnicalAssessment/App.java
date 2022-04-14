package ezoTechnicalAssessment;

import ezoTechnicalAssessment.controller.CharController;
import ezoTechnicalAssessment.dao.*;
import ezoTechnicalAssessment.ui.*;

import java.text.ParseException;

/**
 * Role:Wires the application
 * Choose which implementation of a dependency should be used
 * Instantiate the dependency instance  ----lines 20-22 AND
 * Pass it into the correct constructor(the Controller) -- line 23  AND FINALLY
 * Wire the application (handing things off to the controller by calling the run method on the controller) --- line 24
 */

public class App {

    public static void main(String[] args) throws ParseException{
        UserIO userIO = new UserIOConsoleImpl();
        CharView view = new CharView(userIO);
        CharDao dao = new CharDaoFileImpl();
        CharController controller = new CharController(dao,view);
        controller.run();
    }
}
