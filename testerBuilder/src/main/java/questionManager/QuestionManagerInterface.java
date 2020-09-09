package questionManager;

public interface QuestionManagerInterface {


    String getQ(int key);

    String getA(int key, int givenAnswer);

    int getQuestionsSize();

    int getAnswersSize();

    int getDummyListSize();

}
