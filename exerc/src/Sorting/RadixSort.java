package Sorting;

public class RadixSort {


    private int[] array = {170, 45, 75, 90, 802, 24, 2, 66};

    // get the max

    public int getMax(int[] array) {
        int max = array[0];
        for (int element : array) {
            if (element > max)
                max = element;

        }
        return max;
    }

/*
    public int[] radixSort(int[] array) {

        for (int element : array) {
            element[]
        }
    }



 */

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();

        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println(radixSort.getMax(array));
    }
}

