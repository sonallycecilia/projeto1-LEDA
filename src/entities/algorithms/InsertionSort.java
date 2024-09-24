package entities.algorithms;

import entities.Tweet;

public class InsertionSort {

    public static void sortByDate(Tweet[] array) {
        for (int i = 1; i < array.length; i++) {
            Tweet temp = array[i]; 
            int j = i - 1; 

            String[] tempDate = temp.getFormatted_date().split("/");

            int tempDay = Integer.parseInt(tempDate[0]);
            int tempMonth = Integer.parseInt(tempDate[1]);
            int tempYear = Integer.parseInt(tempDate[2]);

    
            while (j >= 0 && compareDate(array[j], tempDay, tempMonth, tempYear)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    private static boolean compareDate(Tweet tweet, int day, int month, int year) {
        String[] tweetDateParts = tweet.getFormatted_date().split("/");
        int tweetDay = Integer.parseInt(tweetDateParts[0]);
        int tweetMonth = Integer.parseInt(tweetDateParts[1]);
        int tweetYear = Integer.parseInt(tweetDateParts[2]);

        if (tweetYear > year) {
            return true;
        } else if (tweetYear == year) {
            if (tweetMonth > month) {
                return true;
            } else if (tweetMonth == month) {
                return tweetDay > day;
            }
        }
        return false;
    }

    public static void sortByMentionedCount(Tweet[] array){
        for (int i = 1; i < array.length; i++){
            Tweet temp = array[i]; 
            int j = i - 1; 
            
            while (j >= 0 && array[j].getMentioned_person_count() < temp.getMentioned_person_count()){ 
                array[j+1] = array[j];
                j--; 
            }
            array[j+1] = temp;
        }
    }

    public static void sortByUser(Tweet[] array){
        for (int i = 1; i < array.length; i++){
            Tweet temp = array[i]; 
            int j = i - 1; 
            
            while (j >= 0 && (array[j].getUser().compareTo(temp.getUser())) > 0){ 
                array[j+1] = array[j];
                j--; 
            }
            array[j+1] = temp;
        }
    }

}

