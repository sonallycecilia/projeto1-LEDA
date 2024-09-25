package entities.algorithms;

import entities.Tweet;

public class CountingSort {

    public static void sortByDate(Tweet[] array) {
        int n = array.length;
        if (n == 0) return; 

        int[] dateValues = new int[n];
        for (int i = 0; i < n; i++) {
            dateValues[i] = dateToNumber(array[i].getFormatted_date());
        }

        int max = dateValues[0];
        for (int i = 1; i < n; i++) {
            if (dateValues[i] > max) {
                max = dateValues[i];
            }
        }

        int[] count = new int[max + 1];

        for (int i = 0; i < n; i++) {
            count[dateValues[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        Tweet[] sortedArray = new Tweet[n];

        for (int i = n - 1; i >= 0; i--) {
            int value = dateValues[i];
            sortedArray[count[value] - 1] = array[i];
            count[value]--;
        }
        for (int i = 0; i < n; i++) {
            array[i] = sortedArray[i];
        }
    }

    private static int dateToNumber(String date) {
        String[] parts = date.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        return year * 10000 + month * 100 + day;
    }

    public static void sortByMentionedCount(Tweet[] array) {
        int n = array.length;
        if (n == 0) return;
    
        int max = array[0].getMentioned_person_count();
        for (int i = 1; i < n; i++) {
            if (array[i].getMentioned_person_count() > max) {
                max = array[i].getMentioned_person_count();
            }
        }
    
        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[array[i].getMentioned_person_count()]++;
        }
    
        for (int i = max - 1; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        Tweet[] sortedArray = new Tweet[n];
    
        for (int i = n - 1; i >= 0; i--) {
            int value = array[i].getMentioned_person_count();
            sortedArray[count[value] - 1] = array[i];
            count[value]--;
        }
    
        for (int i = 0; i < n; i++) {
            array[i] = sortedArray[i];
        }
    }
}