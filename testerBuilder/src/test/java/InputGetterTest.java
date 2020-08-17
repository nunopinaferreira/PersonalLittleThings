import inputTools.InputGetter;

public class InputGetterTest {

    public static void main(String[] args) {
        InputGetter inputGetterTest = new InputGetter();

        inputGetterTest.getQuestions();
        inputGetterTest.getAnswers();
        int testQA = 29;
        System.out.println(inputGetterTest.getQA(testQA));

    }

}
