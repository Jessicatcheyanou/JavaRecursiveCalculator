package ezoTechnicalAssessment.ui;

/**
 * Defines the methods that must be implemented by any class
 * that wants to interact with the user interface technology
 * (Here the console-based user interface)
 */
public interface UserIO {
    void print(String msg);
    String readString(String prompt);
    int readInt(String prompt);
    int readInt(String prompt,int min,int max);
}
