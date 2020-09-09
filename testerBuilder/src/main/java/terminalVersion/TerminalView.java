package terminalVersion;

import inputTools.InputGetter;
import questionManager.QuestionManager;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalView {


    private InputGetter inputGetterTest = new InputGetter();
    private QuestionManager questionManager = new QuestionManager(inputGetterTest);


    private BufferedReader read = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
    String msg;



    public String getTerminalInput() throws IOException {
        msg = read.readLine();

            if ((!questionManager.getNumList().contains((msg)) || msg == null)) {
                System.out.println("Please insert a number between 1 and 5 or 'quit' to leave");
                getTerminalInput();
            }
        return msg;
    }


    public void startTerminal() {


        String givenAnswer;
        int testQANumber = (int) (Math.random() * questionManager.getQuestionsSize());

            // TODO: 24/08/2020 change it so it doesn't repeat same questions. maybe put this logic in the question manager
            System.out.println("Question nº:" + testQANumber);
            System.out.println(questionManager.getQ(testQANumber));

            try {
                givenAnswer = getTerminalInput();

                if (givenAnswer.equals("quit")) return;

                System.out.println("Your answer was: " + givenAnswer + "\n");
                int givenAnswerNum = Integer.parseInt(givenAnswer);

                System.out.println(questionManager.getA(testQANumber, givenAnswerNum));

                startTerminal();

            } catch (IOException e) {
                e.printStackTrace();
            }
  //      }
    }


    }
