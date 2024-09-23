package entities.algorithms;

public class MergeSort {
    public static void merge(int array[]){
        if (array.length <= 1){
            return;
        } else{
            int midle = array.length / 2;
            int arrayLeft[] = new int[midle];
            int arrayRight[] = new int[array.length - midle];

            for (int i = 0; i < midle; i++){
                arrayLeft[i] = array[i];
            }
            for (int j = midle; j < array.length; j++){
                arrayRight[j - midle] = array[j];
            }

            merge(arrayLeft);
            merge(arrayRight);
            sort(array, arrayLeft, arrayRight);
        }
    }

    public static void sort(int array[], int left[], int right[]){
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length){
            if (left[i] < right[j]){
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < left.length){
            array[k] = left[i];
            i++;
            k++;
        }
        while(j < right.length){
            array[k] = right[j];
            j++;
            k++;
        }
    }    
}
