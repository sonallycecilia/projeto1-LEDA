package entities.algorithms;

import entities.Tweet;

public class MergeSort {

    public static void mergeByDate(Tweet array[]) {
        if (array.length <= 1) {
            return;
        } else {
            int midle = array.length / 2;
            Tweet arrayLeft[] = new Tweet[midle];
            Tweet arrayRight[] = new Tweet[array.length - midle];
            for (int i = 0; i < midle; i++) {
                arrayLeft[i] = array[i];
            }
            for (int j = midle; j < array.length; j++) {
                arrayRight[j - midle] = array[j];
            }
            mergeByDate(arrayLeft);
            mergeByDate(arrayRight);
            sortByDate(array, arrayLeft, arrayRight);
        }
    }

    public static void sortByDate(Tweet array[], Tweet left[], Tweet right[]) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            String[] dateLeft = left[i].getFormatted_date().split("/");
            String[] dateRight = right[j].getFormatted_date().split("/");

            int dayLeft = Integer.parseInt(dateLeft[0]);
            int monthLeft = Integer.parseInt(dateLeft[1]);
            int yearLeft = Integer.parseInt(dateLeft[2]);

            int dayRight = Integer.parseInt(dateRight[0]);
            int monthRight = Integer.parseInt(dateRight[1]);
            int yearRight = Integer.parseInt(dateRight[2]);

            if (yearLeft < yearRight || 
               (yearLeft == yearRight && monthLeft < monthRight) || 
               (yearLeft == yearRight && monthLeft == monthRight && dayLeft <= dayRight)) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    public static void mergeByMentionedCount(Tweet[] array){
        if (array.length <= 1) {
            return;
        } else {
            int midle = array.length / 2;
            Tweet arrayLeft[] = new Tweet[midle];
            Tweet arrayRight[] = new Tweet[array.length - midle];
            for (int i = 0; i < midle; i++) {
                arrayLeft[i] = array[i];
            }
            for (int j = midle; j < array.length; j++) {
                arrayRight[j - midle] = array[j];
            }
            mergeByMentionedCount(arrayLeft);
            mergeByMentionedCount(arrayRight);
            sortByMentionedCount(array, arrayLeft, arrayRight);
        }
    }

    public static void sortByMentionedCount(Tweet[] array, Tweet left[], Tweet right[]){
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].getMentioned_person_count() > right[j].getMentioned_person_count()) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
    
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
    
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
    
    public static void mergeByUser(Tweet[] array){
        if (array.length <= 1) {
            return;
        } else {
            int midle = array.length / 2;
            Tweet arrayLeft[] = new Tweet[midle];
            Tweet arrayRight[] = new Tweet[array.length - midle];
            for (int i = 0; i < midle; i++) {
                arrayLeft[i] = array[i];
            }
            for (int j = midle; j < array.length; j++) {
                arrayRight[j - midle] = array[j];
            }
            mergeByUser(arrayLeft);
            mergeByUser(arrayRight);
            sortByUser(array, arrayLeft, arrayRight);
        }
    }

    public static void sortByUser(Tweet[] array, Tweet left[], Tweet right[]){
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].getUser().compareTo(right[j].getUser()) < 0) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
            while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    //metodos que geram o pior caso
    public static void mergeByReverseDate(Tweet array[]){
        if (array.length <= 1) {
            return;
        } else {
            int midle = array.length / 2;
            Tweet arrayLeft[] = new Tweet[midle];
            Tweet arrayRight[] = new Tweet[array.length - midle];
            for (int i = 0; i < midle; i++) {
                arrayLeft[i] = array[i];
            }
            for (int j = midle; j < array.length; j++) {
                arrayRight[j - midle] = array[j];
            }
            mergeByReverseDate(arrayLeft);
            mergeByReverseDate(arrayRight);
            sortByReverseDate(array, arrayLeft, arrayRight);
        }
    }

    public static void sortByReverseDate(Tweet[] array, Tweet left[], Tweet right[]){
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            String[] dateLeft = left[i].getFormatted_date().split("/");
            String[] dateRight = right[j].getFormatted_date().split("/");

            int dayLeft = Integer.parseInt(dateLeft[0]);
            int monthLeft = Integer.parseInt(dateLeft[1]);
            int yearLeft = Integer.parseInt(dateLeft[2]);

            int dayRight = Integer.parseInt(dateRight[0]);
            int monthRight = Integer.parseInt(dateRight[1]);
            int yearRight = Integer.parseInt(dateRight[2]);

            if (yearLeft > yearRight || 
               (yearLeft == yearRight && monthLeft > monthRight) || 
               (yearLeft == yearRight && monthLeft == monthRight && dayLeft >= dayRight)) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    public static void mergeByReverseMentionedCount(Tweet[] array){
        if (array.length <= 1) {
            return;
        } else {
            int midle = array.length / 2;
            Tweet arrayLeft[] = new Tweet[midle];
            Tweet arrayRight[] = new Tweet[array.length - midle];
            for (int i = 0; i < midle; i++) {
                arrayLeft[i] = array[i];
            }
            for (int j = midle; j < array.length; j++) {
                arrayRight[j - midle] = array[j];
            }
            mergeByReverseMentionedCount(arrayLeft);
            mergeByReverseMentionedCount(arrayRight);
            sortByReverseMentionedCount(array, arrayLeft, arrayRight);
        }
    }

    public static void sortByReverseMentionedCount(Tweet[] array, Tweet[] left, Tweet[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].getMentioned_person_count() > right[j].getMentioned_person_count()) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
    
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
    
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
    
    public static void mergeByReverseUser(Tweet array[]){
        if (array.length <= 1) {
            return;
        } else {
            int midle = array.length / 2;
            Tweet arrayLeft[] = new Tweet[midle];
            Tweet arrayRight[] = new Tweet[array.length - midle];
            for (int i = 0; i < midle; i++) {
                arrayLeft[i] = array[i];
            }
            for (int j = midle; j < array.length; j++) {
                arrayRight[j - midle] = array[j];
            }
            mergeByReverseUser(arrayLeft);
            mergeByReverseUser(arrayRight);
            sortByReverseUser(array, arrayLeft, arrayRight);
        }
    }

    public static void sortByReverseUser(Tweet[] array, Tweet[] left, Tweet[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].getUser().compareTo(right[j].getUser()) > 0) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
            while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

}

