import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import entities.Tweet;

public class Main {
    public static void main(String[] args) throws Exception {
        String dir_database = "C:\\Users\\sonal\\Documents\\vs projects\\databaseTweets";

        Tweet[] database = extract_database(dir_database);
        printArray(database, 10);

    }

    public static Tweet[] extract_database(String dir){
        String path = dir + File.separator + "tweets.csv";
        int lines = 1600000;
        Tweet[] database = new Tweet[lines];
        
        try (BufferedReader file = new BufferedReader(new FileReader(path))){
            String line;
            int i = 0;
            while((line = file.readLine()) != null){
                if(i > 0){ //pulando a linha incial de cabeçalho
                    String[] field =  line.split(","); //separando a linha em campos
                    int target = Integer.parseInt(field[0]);
                    long id = Long.parseLong(field[1]);
        
                    Tweet tweet = new Tweet(target, id, field[2], field[3], field[4], field[5]);
                    database[i] = tweet;
                }
                i++;
            }
        } catch (IOException e) {
            System.out.println("Error extracting data");
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("Error converting number");
            e.printStackTrace();
        }
        return database;
    }

    public static void write_ordened_data(String file_name, String[][] data){

    }

    public static void printArray(Tweet[] database, int quantity){
        for (int i = 0; i < quantity; i++){
            System.out.println(database[i]);
        }
    }
}
