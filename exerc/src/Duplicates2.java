public class Duplicates2 {

    public static void main(String[] args) {

        // finding a duplicate in a array of integers

        Duplicates2 duplicates2 = new Duplicates2();
        int[] array = {2, 6, 2, 3, 7, 1, 6, 8, 9, 22, 1, 2};

        duplicates2.find(array);


    }


    public void find(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j] && i != j) {
                    System.out.println("number: " + array[j] + " and position: " + j);
                }

            }

        }

    }
}




