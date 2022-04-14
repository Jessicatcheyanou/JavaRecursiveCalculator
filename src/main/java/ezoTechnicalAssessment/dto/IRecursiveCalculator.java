package ezoTechnicalAssessment.dto;

import java.util.ArrayList;

public interface IRecursiveCalculator {
    void getDigits(String digit);
    void getOperators(String operator);
    void getNextOperator(ArrayList<Character> nextOperator);
}
