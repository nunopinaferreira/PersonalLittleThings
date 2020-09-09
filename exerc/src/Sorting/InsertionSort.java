package Sorting;

public class InsertionSort {


    // method that picks each number by sequential position in the array, and calls a while loop if :
    // 1. there's an illegal position behind (so less than 0)
    // 2. if the number behind it is bigger.
    // the while will make the position take the number from the position behind (calling respectively previousPos+1 and previousPos);
    // then it will take -1 from those position coordinates. Thus making the same check for the 2 positions behind.
    // after the while ends (because it either reached pos 0 or the sorting checks, it will replace the previousPos+1 with the original number that was picked (currentNum).
    public void insertionSort(int[] array) {


        for (int j = 1; j < array.length; j++) {
            int currentNum = array[j];  // so...currentNum is the number in the position corresponding to the current iteration. It is saved here in currentNum so it can be assigned at the end again.
            int previousPos = j-1;      // previousPos is the position right behind that. so it's number would be array[j-1].

            System.out.println("####### iteration is: " + j);
            System.out.println("currentNum is: " + currentNum);
            System.out.println("previousPos is: " + previousPos);
            System.out.println("array[previousPos] is: " + array[previousPos]);
            int counter = 1;

            while ((previousPos > -1) && (array[previousPos] > currentNum)) { // check if the previousPos is behind the 1st one, thus inexistent - and check if the number in that position is > currentNum

                System.out.println("### while iteration is: " + j+ "." + counter + "\n");
                System.out.println("previousPos was: " + previousPos + " and the number was (array[previousPos]) was " + array[previousPos]);

                  array[previousPos+1] = array[previousPos]; // number in current number position (array[j] at start) is now the same as the number behind it.

                System.out.println("array[previousPos + 1] inside while is NOW: " + array[previousPos +1]);

                   previousPos--;   // previousPos is dynamic and will get "behind" in every WHILE iteration. To ensure it checks numbers behind until the first one.
                                    // it doesn't change anything except the position that will be "worked" in line 21.
                                    // it means that after each while iteration, it will be working on 2 positions further behind.
                System.out.println("previousPos is NOW: "+ previousPos);


                     counter++;
            }

            array[previousPos + 1] = currentNum; // the number that was in the current position (so array[j]) is now put into the previousPos + 1
                                                    // since it hasn't finished the initial iteration, previousPos is still the result of the WHILE --, so it is
                                                    // the last position while that number was lower than the previous one. So the -2 changes all the way back to position 0;
            System.out.println("number is " + array[previousPos+1] + " and currentNum is " + currentNum);

            for (int element : array) {
                System.out.println(element+"");
            };

        }

    }






    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();

        int[] array = {5, 5, 6, 2, 3, 7, 11, 245, 2, 11};

        insertionSort.insertionSort(array);

    }

}
