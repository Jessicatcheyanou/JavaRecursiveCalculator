package ezoTechnicalAssessment.dao;

import ezoTechnicalAssessment.dto.CHAR;

/**
 * This interface defines the methods that must be implemented
 * by any class that wants to play the role of DAO in the application.
 * We will implement a text file-based DAO in the code-along.
 * You could imagine, however, an implementation that only stored
 * student data in memory or one that stored student data in a database.
 * Each class would be different but all would implement that same interface,
 * ensuring that they are all well encapsulated.
 * Note that the CharController only uses this interface to
 * reference the DAO — it is completely unaware of the implementation details
 */

import java.text.ParseException;
import java.util.*;

public interface CharDao {

    void addChar(CHAR dvd) throws ParseException, CharDaoException;
    List<CHAR> getAllChars() throws ParseException, CharDaoException;


}
