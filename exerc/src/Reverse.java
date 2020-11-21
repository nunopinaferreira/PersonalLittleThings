public class Reverse {

    // reversing an array of chars
    public void reverse(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array.length);
            System.out.println(i);
            char hold = array[array.length-(i+1)];
            System.out.println("hold is: " + hold);

            array[array.length-(i+1)] = array[i];
            array[i] = hold;
            System.out.println(array[i]);

        }
        for (char element : array) {
            System.out.println(element);
        }
    }


    // reverse an array in-place
    public void reverseInPlace(String[] array) {

        for (int i = 0; i <= (array.length-1)/2; i++) {

            String currentElement = array[i]; // saves i element to variable
            array[i] = array[array.length - (i+1)]; // gives i element the value of (last element-i) - plus 1 to compensate i=0
            array[array.length - (i+1)] = currentElement; // gives last element-i the value saved in currentElement

        }

        for (String element: array) {
            System.out.println(element);
        }

    };



    public static void main(String[] args) {
        String test = "Hello, I am Morgul";

        Reverse reverse = new Reverse();
        char[] array = test.toCharArray();
        reverse.reverse(array);

        String[] arrayTest = {"one", "two", "three", "four", "five", "six", "seven"};
        reverse.reverseInPlace(arrayTest);

    }


}
