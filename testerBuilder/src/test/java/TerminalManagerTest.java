import inputTools.InputGetter;
import questionManager.QuestionManager;
import terminalVersion.TerminalView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalManagerTest {

    private BufferedReader read = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
    String msg;


    public String getTerminalInput() throws IOException {
        msg = read.readLine();
        return msg;
    }


    public static void main(String[] args) {
        InputGetter inputGetterTest = new InputGetter();
        QuestionManager questionManager = new QuestionManager(inputGetterTest);
        TerminalManagerTest terminalManagerTest = new TerminalManagerTest();

        String givenAnswer = "empty";

        while (!givenAnswer.equals("exit")) {

            // TODO: 24/08/2020 change it so it doesn't repeat same questions. maybe put this logic in the question manager
            int testQANumber = (int) (Math.random() * questionManager.getQuestionsSize());

            System.out.println("Question nº:" + testQANumber);
            System.out.println(questionManager.getQ(testQANumber));

            // System.out.println(questionManager.getQ(testQANumber));

            try {
                givenAnswer = terminalManagerTest.getTerminalInput();
                System.out.println("Your answer was: " + givenAnswer + "\n");
                int givenAnswerNum = Integer.parseInt(givenAnswer);
                System.out.println(questionManager.getA(testQANumber, givenAnswerNum));
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }





}
