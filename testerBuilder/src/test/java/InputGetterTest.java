import inputTools.InputGetter;
import questionManager.QuestionManager;
import terminalVersion.TerminalViewer;

import java.io.IOException;

public class InputGetterTest {

    public static void main(String[] args) {
        InputGetter inputGetterTest = new InputGetter();
        TerminalViewer terminalViewer = new TerminalViewer();
        QuestionManager questionManager = new QuestionManager(inputGetterTest);


        String givenAnswer = "empty";

        while (!givenAnswer.equals("exit")) {
            int testQANumber = (int) (Math.random() * inputGetterTest.getQuestionsSize());

            System.out.println("Question nº:" + testQANumber);
            System.out.println(questionManager.getQ(testQANumber));

            try {
                givenAnswer = terminalViewer.getTerminalInput();
                System.out.println("A: " + givenAnswer + "\n");
                // getCorrectAnswer
            } catch (IOException e) {
                e.printStackTrace();
            }







        }
    }


}
