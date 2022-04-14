package ezoTechnicalAssessment.dao;

import ezoTechnicalAssessment.dto.CHAR;

import java.io.*;
import java.util.*;

/**
 * The DAO is responsible for the
 * persistence and retrieval of calculator
 * data into and out of files (.txt)
 * The DAO cannot access the view
 */

public class CharDaoFileImpl implements CharDao{
    private final List<CHAR> chars = new ArrayList<>();
    public static final String CHAR_FILE = "CALCULATOR.txt";


    @Override
    public void addChar(CHAR calc) throws CharDaoException {
        loadCHARCollection();
        chars.add(calc);
        writeCHARCollection();
    }


    @Override
    public List<CHAR> getAllChars() throws CharDaoException {
        loadCHARCollection();
        return chars;
    }



    private CHAR unmarshallCHAR(String charAsText) {

        CHAR charFromFile = new CHAR();
        charFromFile.setCalculator(charAsText);

        return charFromFile;

    }

    private void loadCHARCollection() throws CharDaoException {
        Scanner scanner;
        String currentLine;
        CHAR currentCHAR;

        try {
            //Create Scanner for reading the existing file
            scanner = new Scanner(new BufferedReader(new FileReader(CHAR_FILE)));

        }catch (FileNotFoundException e){
            throw new CharDaoException("Could not load DVD data in memory.",e);

        }

        while (scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentCHAR = unmarshallCHAR(currentLine);
            chars.add(currentCHAR);

        }
        scanner.close();



    }

    private String marshallCHAR(CHAR aCHAR){
        return  aCHAR.getCalculator();
    }

    //Write the DVD Information from memory to file
    private void writeCHARCollection() throws CharDaoException {
          PrintWriter out;

          try {
              out = new PrintWriter(new FileWriter(CHAR_FILE));
          }catch (IOException e){
              throw new CharDaoException("Could not save Calculator Data.", e);
          }

          String charAsText;
          List<CHAR> dvdList = this.getAllChars();
          for (CHAR currentCHAR:dvdList){
              charAsText = marshallCHAR(currentCHAR);
              out.println(charAsText);
              out.flush();

          }
          dvdList.clear();
          out.close();

    }
}
