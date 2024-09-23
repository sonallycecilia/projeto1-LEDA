package entities.algorithms;

import entities.Tweet;

public class BubbleSort {
    
    public static void sortByDate(Tweet[] data){
        for (int i = 0; i < data.length - 1; i++){
            for (int j = 0; j < data.length -1; j++){
                String day[] = data[j].getFormatted_date().split("/");
                String nextDay[] = data[j+1].getFormatted_date().split("/");

                int day1 = Integer.parseInt(day[0]);
                int month1 = Integer.parseInt(day[1]);
                int year1 = Integer.parseInt(day[2]);
        
                int day2 = Integer.parseInt(nextDay[0]);
                int month2 = Integer.parseInt(nextDay[1]);
                int year2 = Integer.parseInt(nextDay[2]);

                if (year1 > year2 || 
                   (year1 == year2 && month1 > month2) || 
                   (year1 == year2 && month1 == month2 && day1 > day2)) {
                    Tweet temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void sortByMentionedPersonsCount(Tweet[] data){
        for (int i = 0; i < data.length - 1; i++){
            for (int j = 0; j < data.length -1; j++){
                if (data[j].getMentioned_person_count() < 
                data[j+1].getMentioned_person_count()) {
                    Tweet temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void sortByUserName(Tweet[] data){
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].getUser().compareTo(data[j + 1].getUser()) > 0) {
                    Tweet temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}
