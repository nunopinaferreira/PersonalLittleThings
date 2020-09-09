package inputTools;

import java.io.*;

public class GenerateAnswers {


    public static void main(String[] args) {

        String filepath = "src/lib/testfileA.txt";
        GenerateAnswers generateAnswers = new GenerateAnswers();
        generateAnswers.writeTestFile(filepath);

    }


    public void writeTestFile (String filepath) {
        try {


            PrintWriter write = new PrintWriter(filepath);

            for (int i = 1; i < 142; i++) {
                String words = i + ".test";
                write.println(words);

            };
            write.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}