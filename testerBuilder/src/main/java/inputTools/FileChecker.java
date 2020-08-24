package inputTools;

import inputTools.customExceptions.NotAValidNumberException;

public class FileChecker {

    // Checks if the file contains the expected structure:
    // un-repeatable number + dot(.) + sentence per line.
/*
    // checks for number. returns number.
    public int checkNumberList(String line, int dotIndex) {
        int beforeDot =  Integer.valueOf(line.substring(0, dotIndex));
        String afterDot = line.substring(dotIndex+1);
        beforeDot = prevNumber + 1; // compare numbers

        return beforeDot;
    }


    // checks for dot. returns dot index.
    public int checkDot(String line) {
        int dotIndex = line.indexOf(".");

        return dotIndex;

    }


    // checks for sentence starting after dot and ending before line change?
    public String checkSentencePerLine() {}


*/


    public int checksNumberConforms(String phraseNumber) throws NotAValidNumberException {
        if (phraseNumber == null || Integer.parseInt(phraseNumber) < 0)
            throw new NotAValidNumberException("Number is incorrect");
        return Integer.parseInt(phraseNumber);
    }


}
