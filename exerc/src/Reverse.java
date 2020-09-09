public class Reverse {


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

    public void reverse(String string){


    }


    public static void main(String[] args) {
        String test = "Hello, I am Morgul";

        Reverse reverse = new Reverse();
        char[] array = test.toCharArray();
        reverse.reverse(array);



    }


}
