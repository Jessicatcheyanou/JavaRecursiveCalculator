package ezoTechnicalAssessment.dto;

/**
 * The DTO is the container for Calcutions Data.
 * The DTO and DAO comprise the Model.
 *
 * NB:All components(Model,View, and Controller) can use DTO's
 */

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




