import java.util.ArrayList;
import java.util.HashMap;


public class Counting {


    public int countWords(String words, String letter) {

        String[] array = words.split("");


        HashMap<String, Integer> countList = new HashMap();


        for (String element : array) {

                int counter = 0;
                if (countList.containsKey(element)) {
                    counter = countList.get(element);
                }

                countList.put(element, counter + 1);


            }


        if (countList.containsKey(letter)) return countList.get(letter);
            else return 0;
    }

    public static void main(String[] args) {

        Counting counting = new Counting();
        String words = "How do you count the occurrence of a given character in a string?";

        String a = " ";

        System.out.println(counting.countWords(words, a));

    }


}