package ezoTechnicalAssessment.ui;

import java.util.Scanner;

/**
 * Handles the interaction between the User and
 * the Console(Terminal)
 * via the Scanner
 */

public class UserIOConsoleImpl implements UserIO{
    final private Scanner console = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return console.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput){
            try {
                String stringValue = this.readString(prompt);
                num = Integer.parseInt(stringValue);
                invalidInput = false;
            } catch (NumberFormatException e){
                this.print("Input Error.Please try again.");
            }
        }
        return num;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int result;
        do {
            result = readInt(prompt);
        }while (result < min || result > max);
        return result;
    }
}
