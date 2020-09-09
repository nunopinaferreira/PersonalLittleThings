import java.util.Arrays;

public class Anagrams {



    public boolean anagramChecker(char[] one, char[] two) {
        if (one.length != two.length) return false;

        for (int i=0; i < one.length; i++) {
            if (one[i] != two[i]) return false;
        }

    return true;
    }


    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        String one = "listen";
        String two = "siledt";

        char[] oneChar = one.toCharArray();
        char[] twoChar = two.toCharArray();
        Arrays.sort(oneChar);
        Arrays.sort(twoChar);

        System.out.println(anagrams.anagramChecker(oneChar, twoChar));

    }

}
