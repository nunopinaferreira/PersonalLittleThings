package questionManager;

import inputTools.InputGetter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class QuestionManager implements QuestionManagerInterface {

    private HashMap<Integer, String> questions;
    private HashMap<Integer, String> answers;
    private HashMap<Integer, String> dummyList;

    private String[] currentQuestion;
    private ArrayList numList = new ArrayList();


    private void createAllowedAnswers() {
        if (numList.size() >= 5) return;

            String[] numbers = {"1", "2", "3", "4", "5", "quit"};
            for (String element : numbers) {
                numList.add(element);
            }
        }

    public ArrayList getNumList() {
        return numList;
    }


    // constructor
    public QuestionManager(InputGetter inputGetter) {
        questions = inputGetter.getQuestions();
        answers = inputGetter.getAnswers();
        dummyList = inputGetter.getDummyList();

        createAllowedAnswers();

    }



    // method to get questions and dummy answers from map
    @Override
    public String getQ(int key) {

        String Q = questions.get(key);
        HashSet<String> questionOptions = new HashSet<>(); //a Set to gather the presented questions;
        questionOptions.add(answers.get(key));

        while (questionOptions.size() < 5) { // will add random answers as options to the Set until 5;
                    questionOptions.add(answers.get((int) (Math.random() * answers.size())));
                }

        currentQuestion = questionOptions.toArray(new String[questionOptions.size()]);

        String fullQuestion = (
                            "QUESTION: " + Q + "\n" + "\n" +
                            "#1: " + currentQuestion[0] + "\n" +
                            "#2: " + currentQuestion[1] + "\n" +
                            "#3: " + currentQuestion[2]+ "\n" +
                            "#4: " + currentQuestion[3] + "\n" +
                            "#5: " + currentQuestion[4]+ "\n" + "\n" +
                            "ANSWER (1 to 5): "
                            ); //+ "A: " + options;

        return fullQuestion;
    }



    // method to get answers from map and compare with the given answer.
    // If the answer is correct it will remove the question from the Map (but not the answer);
    // This should ensure that correctly answered questions won't repeat
    @Override
    public String getA(int key, int givenAnswer) {

        String A = answers.get(key);

        System.out.println("answer translates into: " + currentQuestion[givenAnswer-1]);
        System.out.println("A translates into: " + A);

            if (currentQuestion[givenAnswer-1].equals(A)) {
                String fullAnswer = "\n" + "$$$$$ CORRECT $$$$$$  " + "\n" + "Your answer: " + "'" + A + "'" + " is correct!" + "\n";

                questions.remove(key);

                return fullAnswer;
            };

        String incorrectAnswer = "\n" + "Incorrect! Try another time." + "\n";



        return incorrectAnswer;
    }


    @Override
    public int getQuestionsSize() {
        return questions.size();
    };

    @Override
    public int getAnswersSize() {
        return answers.size();
    }

    @Override
    public int getDummyListSize() {
        return dummyList.size();
    }


}
