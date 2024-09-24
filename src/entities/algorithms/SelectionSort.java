package entities.algorithms;

import entities.Tweet;

public class SelectionSort {

    public static void sortByDate(Tweet[] array) {
        for (int i = 0; i < array.length; i++) {
            int menor = i;
            for (int j = i + 1; j < array.length; j++) {
                if (compareDate(array[j], array[menor])) {
                    menor = j;
                }
            }
            Tweet temp = array[menor];
            array[menor] = array[i];
            array[i] = temp;
        }
    }
    
    private static boolean compareDate(Tweet tweet1, Tweet tweet2) {
        String[] date1Parts = tweet1.getFormatted_date().split("/");
        int day1 = Integer.parseInt(date1Parts[0]);
        int month1 = Integer.parseInt(date1Parts[1]);
        int year1 = Integer.parseInt(date1Parts[2]);
    
        String[] date2Parts = tweet2.getFormatted_date().split("/");
        int day2 = Integer.parseInt(date2Parts[0]);
        int month2 = Integer.parseInt(date2Parts[1]);
        int year2 = Integer.parseInt(date2Parts[2]);
    
        if (year1 < year2) {
            return true; 
        } else if (year1 == year2) {
            if (month1 < month2) {
                return true;
            } else if (month1 == month2) {
                return day1 < day2;
            }
        }
        return false;
    }
    
    public static void sortByMentionedCount(Tweet[] array){
        for (int i = 0; i < array.length; i++){
            int menor = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j].getMentioned_person_count() > array[menor].getMentioned_person_count()){
                    menor = j;
                }
            }
            Tweet temp = array[menor];
            array[menor] = array[i];
            array[i] = temp;
        }
    }

    public static void sortByUser(Tweet[] array){
        for (int i = 0; i < array.length; i++){
            int menor = i;
            for (int j = i + 1; j < array.length; j++){
                if ((array[j].getUser().compareTo(array[menor].getUser())) < 0){
                    menor = j;
                }
            }
            Tweet temp = array[menor];
            array[menor] = array[i];
            array[i] = temp;
        }
    }

}
