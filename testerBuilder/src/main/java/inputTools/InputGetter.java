package inputTools;


import java.io.*;
import java.util.HashMap;

public class InputGetter {

    private HashMap<Integer, String> questionList = new HashMap<Integer, String>();
    private String filepathQ = "src/lib/testfileQ.txt";
    private HashMap<Integer, String> answerList = new HashMap<Integer, String>();
    private String filepathA = "src/lib/testfileA.txt";

    // gets the questions from a txt file and puts them in a hashmap.
    // txt must have one question per line, starting with a unique number
    // and a . separating question from said number.

    public void getQuestions() {
        getInputs(filepathQ);
    }

    public void getAnswers() {
        getInputs(filepathA);
    }

    public void getInputs(String filepath) {
        try {
            FileInputStream file = new FileInputStream(filepath);
            String thisLine;
            BufferedInputStream bufferedFile = new BufferedInputStream(file);
            InputStreamReader readFile = new InputStreamReader(bufferedFile);
            BufferedReader readPhrase = new BufferedReader(readFile);

            while ((thisLine = readPhrase.readLine()) !=null) {
                String line = thisLine;
                int divider = line.indexOf(".");
                String phrase = line.substring(divider+1);
                int num = Integer.parseInt(line.substring(0, divider));

                if (filepath.equals(filepathQ)) {
                    questionList.put(num, phrase);
                }
                if (filepath.equals(filepathA)) {
                        answerList.put(num, phrase);
                    }
                }
            file.close();
            bufferedFile.close();
            readFile.close();
            readPhrase.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public String getQA(int key) {

        String Q = questionList.get(key);
        String A = answerList.get(key);
        String QA = "Q: " + Q + "\n" + "A: " + A;
        return QA;
    }


    }
