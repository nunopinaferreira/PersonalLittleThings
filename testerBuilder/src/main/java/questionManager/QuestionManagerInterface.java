package questionManager;

public interface QuestionManagerInterface {

    String checkCorrectAnswer(int questionNum);

    String getQ(int key);

    String getA(int key);

    int getQuestionsSize();

    int getAnswersSize();

    int getDummyListSize();

}
