package ezoTechnicalAssessment.dto;

import java.util.Date;
import java.util.UUID;

public class CHAR {
    private String calculator;


    public CHAR() {
    }

    //GETTER METHODS
    public String getCalculator() {
        return calculator;
    }



    //SETTER METHODS
    public void setCalculator(String calculator) {
        this.calculator = calculator;
    }

    @Override
    public String toString() {
        return "CHAR{" +
                "calculator='" + calculator + '\'' +
                '}';
    }
}




