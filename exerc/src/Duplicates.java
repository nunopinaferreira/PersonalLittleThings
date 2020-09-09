

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Duplicates {


    HashSet<String> hashSet = new HashSet();
    ArrayList<String> arrayList = new ArrayList<>();
    HashMap<Integer, String> hashMap = new HashMap<>();

    public void getStringDivided(String string) {

        for (int i = 0; i < string.length(); i++) {
            if (hashSet.add(string.substring(i, i + 1))) continue;


            arrayList.add(string.substring(i, i + 1));
            arrayList.sort(String::compareTo);
            hashMap.put(i, string.substring(i, i + 1));
        }
        System.out.println(hashSet);
        System.out.println(arrayList);
        String[] repeatedLetters = arrayList.toArray(new String[arrayList.size()]);
        System.out.println("map: " + hashMap);
    }


    public static void main(String[] args) {


        String string = "Let's try it without much complexity for once";

        Duplicates duplicates = new Duplicates();

        duplicates.getStringDivided(string);

        char[] arrayChar = string.toCharArray();
        for (char element : arrayChar) {
            System.out.println(element);
        }
    }

}