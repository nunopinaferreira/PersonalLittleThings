package inputTools;


import inputTools.customExceptions.NotAValidNumberException;

import java.io.*;
import java.util.HashMap;

public class InputGetter {

    private HashMap<Integer, String> questionList = new HashMap<Integer, String>();
    private String filepathQ = "src/lib/testfileQ.txt";
    private HashMap<Integer, String> answerList = new HashMap<Integer, String>();
    private String filepathA = "src/lib/testfileA.txt";
    private HashMap<Integer, String> dummyList = new HashMap<>();
    private String filepathDA = "src/lib/testfileDA.txt";
    private FileChecker fileChecker = new FileChecker();

    // gets the questions from a txt file and puts them in a hashmap.
    // txt must have one question per line, starting with a unique number
    // and a . separating question from said number.


    public HashMap<Integer, String> getQuestions() {
        getInputs(filepathQ, "Q");
        return questionList;
    }

    public HashMap getAnswers() {
        getInputs(filepathA, "A");
        return answerList;
    }

    public HashMap getDummyList() {
        getInputs(filepathDA, "DA");
        return dummyList;
    }

    public void getInputs(String filepath, String documentType) {
        try {
            BufferedReader readPhrase = new BufferedReader(new FileReader(filepath));
            String thisLine;


            while ((thisLine = readPhrase.readLine()) !=null) {
                String line = thisLine;
                int dividerBetweenNumberAndPhrase = line.indexOf(".");

                String phrase = line.substring(dividerBetweenNumberAndPhrase + 1);
                String phraseNumber = line.substring(0, dividerBetweenNumberAndPhrase);

                int num = fileChecker.checksNumberConforms(phraseNumber);
                    line.indexOf("#");

                if (filepath.equals(filepathQ)) {
                    questionList.put(num, phrase);
                }
                if (filepath.equals(filepathA)) {
                        answerList.put(num, phrase);
                    }
                }

            readPhrase.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotAValidNumberException e) {
            e.printStackTrace();
        }
    }


    private void putIntoList(String type, int phraseNumber, String phrase) {
        if (type.equals("Q")) {
            questionList.put(phraseNumber, phrase);
        }

        if (type.equals("A")) {
            answerList.put(phraseNumber, phrase);
        }

        if (type.equals("DA")) {
            dummyList.put(phraseNumber, phrase);
        }
    }

    }
