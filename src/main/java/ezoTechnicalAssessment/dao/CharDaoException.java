package ezoTechnicalAssessment.dao;

/**
 * The Application's Specific Exception Class
 * When called(through it's constructor),
 * catches the possible application's exception thrown and
 * the message you would have defined for it
 */
public class CharDaoException extends Exception{

    public CharDaoException(String message, Throwable cause){
        super(message, cause);
    }
}
