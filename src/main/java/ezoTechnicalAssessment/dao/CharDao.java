package ezoTechnicalAssessment.dao;

import ezoTechnicalAssessment.dto.CHAR;

import java.text.ParseException;
import java.util.*;

public interface CharDao {

    void addChar(CHAR dvd) throws ParseException, CharDaoException;
    List<CHAR> getAllChars() throws ParseException, CharDaoException;


}
