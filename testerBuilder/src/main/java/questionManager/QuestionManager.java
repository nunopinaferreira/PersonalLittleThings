package questionManager;

import inputTools.InputGetter;

import java.util.HashMap;

public class QuestionManager implements QuestionManagerInterface {

    private InputGetter inputGetter;
    private HashMap<Integer, String> questions;
    private HashMap<Integer, String> answers;
    private HashMap<Integer, String> dummyList;

    // constructor
    public QuestionManager(InputGetter inputGetter) {
        this.inputGetter = inputGetter;
        questions = inputGetter.getQuestions();
        answers = inputGetter.getAnswers();
        dummyList = inputGetter.getDummyList();
    }

    // method to compare given answer with answer and dummyList maps
    @Override
    public String checkCorrectAnswer(int questionNum) {
        return null;
    }


    // method to get questions and dummy answers from map
    @Override
    public String getQ(int key) {

        String Q = questions.get(key);
        //String A = answerList.get(key);
        String fullQuestion = "Q: " + Q + "\n" + "Answer: "; //+ "A: " + options;
        return fullQuestion;
    }

    // method to get answers from map
    @Override
    public String getA(int key) {

        String A = answers.get(key);
        String fullAnswer = "A: " + A + "\n";
        return fullAnswer;
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
