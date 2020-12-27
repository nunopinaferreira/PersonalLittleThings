import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    // fibonacci numbers must be equal to the sum of the previous two numbers IN THE FIBONACCI ALREADY DONE LIST;
    // add in every number that complies to the above statement up until the given fiboNum
    // ITERATING through all numbers in sequence until the given fiboNum
    public List iterationFibonacci(int fiboNum) {


        // if it implies the sum of the 2 previous ones, let's start at the 3rd number
        ArrayList<Integer> fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(0);
        fibonacciSequence.add(1);


        for (int i = 1; i <= fiboNum; i++) {
            int posMinusOne = fibonacciSequence.size()-1;
            int posMinusTwo = fibonacciSequence.size()-2;

            if (i == (fibonacciSequence.get(posMinusOne)+fibonacciSequence.get(posMinusTwo))) { // check "is a fibonacci number"
                fibonacciSequence.add(i); // add to the list

                System.out.println("True: " + i + " & " +
                        (fibonacciSequence.get(posMinusOne) + fibonacciSequence.get(posMinusTwo)) +
                        " / " + fibonacciSequence.get(posMinusOne) +
                        " / " + fibonacciSequence.get(posMinusTwo));
                }
                System.out.println("False: " + i + " & " +
                        (fibonacciSequence.get(posMinusOne) + fibonacciSequence.get(posMinusTwo)) +
                        " / " + fibonacciSequence.get(posMinusOne) +
                        " / " + fibonacciSequence.get(posMinusTwo));
            }

        return fibonacciSequence;
    }



    // RECURSION, so a function must call upon itself with given argument number (int), add +1 to it, and return that number to a new call of itself
    // Function receives a number as argument
    // it checks upon the fibonacci list if this is a fibonacci number
    // if it is, it adds that number to the list
    // it returns that number +1 and calls upon itself. 

    public static int fib(int n) {

        if ((n == 0) || (n == 1)) {
            System.out.println("n is " + n);

            return n;
        }

        else
            System.out.println("else trigger " + n);
            return fib(n - 1) + fib(n - 2);
    }





    public static void main(String[] args) {


        Fibonacci iteration = new Fibonacci();

        /*
        List iterationResult = iteration.iterationFibonacci(5000);

        for (Object element: iterationResult) {
            System.out.println(element);
        }
        */


        System.out.println("fib num is " + fib(5));

    }



}