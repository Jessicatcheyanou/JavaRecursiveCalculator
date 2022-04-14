package ezoTechnicalAssessment.dto;

import java.util.ArrayList;

/**
 * Defines the Calculator's use case
 */

public interface IRecursiveCalculator {
    void getDigits(String digit);
    void getOperators(String operator);
    void getNextOperator(ArrayList<Character> nextOperator);
}
