package ezoTechnicalAssessment.dto;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implements the calculator's use cases
 */

public class RecursiveCalculator implements IRecursiveCalculator {
    public static Character[] arrayOfOperators = {'/','*','+','-'};

    public static final String REGEXOPERATORS = "[/+,-,/*,/^,//,-]";
    public static final String REGEXDIGITS = "(\\d+\\.?\\d*)";
    public static final String REGEXCALCULATOR = "^[\\d\\+\\/\\*\\.\\^\\- \\(\\)]*$";


    public static ArrayList<Character> subtractionAndAdditionOperators = new ArrayList<>();
    public static ArrayList<Character> threeConsecutiveSubtractionOperators = new ArrayList<>();
    public static ArrayList<Character> additionAndSubractionOperators = new ArrayList<>();
    public static ArrayList<Character> additionOperator = new ArrayList<>();
    public static ArrayList<Character> subtractionOperator = new ArrayList<>();


    public static ArrayList<Double> digits = new ArrayList<>();
    public static ArrayList<Character> operators = new ArrayList<>();
    public static String result;

    public String calculateInput(String input){
        System.out.println("Validating Input format...");
        boolean startsWithSqrt = input.startsWith("sqrt");

        Pattern pattern = Pattern.compile(REGEXCALCULATOR);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches() && !startsWithSqrt){
            System.out.println("Error..Enter a valid input format to calculate");
            return null;
        }
        if (startsWithSqrt){
            getDigits(input);
            for (Double digit : digits) {
                result = String.valueOf(Math.sqrt(digit));
            }

            digits.clear();
            System.out.println(result);
            return result;
        }
        getDigits(input);
        getOperators(input);
        getNextOperator(operators);

        for (Double digit : digits) {
            result = String.valueOf(digit);
        }
        digits.clear();
        operators.clear();
        System.out.println(result);

       return result;
    }


    @Override
    public void getDigits(String digit) {
        System.out.println("Getting digits");

        Pattern pattern = Pattern.compile(REGEXDIGITS);
        Matcher matcher = pattern.matcher(digit);

        while (matcher.find()){
            double x = Double.parseDouble(digit.substring(matcher.start(), matcher.end()));
            digits.add(x);
            System.out.println(digits);
        }
        System.out.println("Finished getting digits...");

    }

    @Override
    public void getOperators(String operator) {
        System.out.println("Getting operators...");
        Pattern pattern = Pattern.compile(REGEXOPERATORS);
        Matcher matcher = pattern.matcher(operator);

        while (matcher.find()){
            operators.add(operator.charAt(matcher.start()));
            System.out.println(operators);
        }
        System.out.println("Finished Getting operators..");

    }

    @Override
    public void getNextOperator(ArrayList<Character> operators) {
        subtractionAndAdditionOperators.add('-');
        subtractionAndAdditionOperators.add('+');

        additionAndSubractionOperators.add('+');
        additionAndSubractionOperators.add('-');

        threeConsecutiveSubtractionOperators.add('-');
        threeConsecutiveSubtractionOperators.add('-');
        threeConsecutiveSubtractionOperators.add('-');


        additionOperator.add('+');
        subtractionOperator.add('-');

        for (Character op:arrayOfOperators) {
            for (int i = 0 ; i < operators.size();i++){

                if (operators.get(i) == '^'){
                    System.out.println("Order");
                    operators.remove(i);
                    digits.set(i,(Math.pow(digits.get(i),digits.get(i + 1))));
                    digits.remove(i + 1);
                    if (operators.isEmpty()){
                        i -= 1;
                    } else {
                        i += 1;
                    }

                }
            }
             for (int i = 0 ; i < operators.size();i++){

                if (operators.get(i) == '/'){
                    System.out.println("Division");
                    operators.remove(i);
                    if (digits.get(i + 1) == 0) {
                        System.out.println("Error");
                        break;
                    }
                    digits.set(i,(digits.get(i) / digits.get(i + 1)));
                    digits.remove(i + 1);
                    if (operators.isEmpty()){
                        i -= 1;
                    } else {
                        i += 1;
                    }

                }
            }

            for (int i = 0; i < operators.size(); i++){

                 if (operators.get(i) == '*'){
                     System.out.println("Multiply");
                     operators.remove(i);
                     digits.set(i,(digits.get(i) * digits.get(i+1)));
                     digits.remove(i+1);
                     if (operators.isEmpty()){
                         i -= 1;
                     } else {
                         i += 1;
                     }

                 }
            }

            for (int i = 0; i < operators.size(); i++){
                if (operators.get(i) == '+'){
                    System.out.println("Addition");
                    if (digits.size() == 2 && operators.equals(subtractionAndAdditionOperators)){
                              System.out.println("Subtraction and addition operators");
                              operators.remove(i);
                              System.out.println("List of remaining operators" + operators);
                              digits.set(0,(-digits.get(0) + digits.get(1)));
                              System.out.println("After performing addition and setting it's result in list" +digits);
                              digits.remove(i);
                              operators.remove(i-1);

                              System.out.println("After performing addition and removing index" + digits);
                              break;

                    }

                    if (digits.size() == 2 && operators.equals(additionAndSubractionOperators)){
                        System.out.println("Addition and Subtraction operators");
                        operators.remove(i);
                        System.out.println("List of remaining operators" + operators);
                        digits.set(0,(+digits.get(0) - digits.get(1)));
                        System.out.println("After performing addition and setting it's result in list" +digits);
                        digits.remove(i+1);
                        operators.remove(i);

                        System.out.println("After performing addition and removing index" + digits);
                        break;

                    }

                        System.out.println("Only Addition operator");
                        operators.remove(i);
                        System.out.println("List of remaining operators" + operators);
                        digits.set(i,(digits.get(i) + digits.get(i+1)));
                        System.out.println("After performing addition and setting it's result in list" +digits);
                        digits.remove(i+1);
                        System.out.println("After performing addition and removing index" + digits);
                        if (operators.isEmpty()){
                            break;
                        } else {
                            i += 1;
                        }
                    }

                    System.out.println("index remaining after adding"+i);

            }

            for (int i = 0; i < operators.size(); i++){

                if (operators.get(i) == '-'){
                    System.out.println("Subtraction");
                    if (digits.size() == 2 && operators.equals(threeConsecutiveSubtractionOperators)){
                        operators.remove(i);
                        System.out.println("List of remaining operators" + operators);
                        digits.set(0,(-digits.get(0) + digits.get(1)));
                        System.out.println("After performing subtraction and setting it's result in list" +digits);
                        digits.remove(i+1);
                        operators.remove(i);
                        operators.remove(i);


                        System.out.println("After performing addition and removing index" + digits);
                        break;

                    } else{
                        operators.remove(i);
                        System.out.println("List of remaining operators" + operators);
                        digits.set(i,(digits.get(i) - digits.get(i+1)));
                        System.out.println("After performing subtraction and setting it's result in list" +digits);
                        digits.remove(i+1);
                        System.out.println("After performing subtraction and removing index" + digits);
                        if (operators.isEmpty()){
                            i -= 1;
                        } else {
                            i += 1;
                        }
                        System.out.println("index remaining after subtraction" +i);

                    }

                }
            }


        }
    }
}
