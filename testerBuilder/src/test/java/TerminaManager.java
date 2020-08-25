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

            // TODO: 24/08/2020
            // change it so it doesn't repeat same questions. maybe put this logic in the question manager
            int testQANumber = (int) (Math.random() * questionManager.getQuestionsSize());

            System.out.println("Question nº:" + testQANumber);
            System.out.println(questionManager.getQ(testQANumber));

            // System.out.println(questionManager.getQ(testQANumber));

            try {
                givenAnswer = terminalViewer.getTerminalInput();
                System.out.println("Your answer was: " + givenAnswer + "\n");
                int givenAnswerNum = Integer.parseInt(givenAnswer);
                System.out.println(questionManager.getA(testQANumber, givenAnswerNum));
            } catch (IOException e) {
                e.printStackTrace();
            }







        }
    }


}
