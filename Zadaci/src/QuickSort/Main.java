package QuickSort;

import java.util.Arrays;


public class Main {

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }


    // WRITE PIVOT METHOD HERE //
    //                         //
    //                         //
    //                         //
    //                         //
    /////////////////////////////


    public static void main(String[] args) {

        int[] myArray = {4,6,1,7,3,2,5};

        int returnedIndex = pivot(myArray, 0, 6);

        System.out.println( "Returned Index: " + returnedIndex);

        System.out.println( Arrays.toString( myArray ) );

        quickSort(myArray);
        System.out.println(Arrays.toString( myArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            Returned Index: 3
            [2, 1, 3, 4, 6, 7, 5]

         */

    }
    private static int pivot(int[] array, int pivotIndex, int endIndex) {
     int swapIndex = pivotIndex;
     for (int i = pivotIndex+1; i <= endIndex; i++) {
         if (array[i] < array[pivotIndex]) {
             swapIndex++;
             swap(array, swapIndex,i);
         }
     }
     swap(array, pivotIndex, swapIndex);
     return swapIndex;
    }

    public static void quickSortHelper(int[] array, int start, int end) {
        if (start < end) {
            int pivot = pivot(array, start, end);
            quickSortHelper(array, start, pivot - 1);
            quickSortHelper(array, pivot + 1, end);
        }
    }

    public static void quickSort(int[] array){
        quickSortHelper(array, 0, array.length - 1);
    }

}