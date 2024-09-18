import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entities.Tweet;

public class Main {
    public static void main(String[] args) throws Exception {
        String dir_tweets_database = "C:\\Users\\sonal\\Documents\\vs projects\\databaseTweets";
        String dir_project_database = "C:\\Users\\sonal\\Documents\\vs projects\\projeto1-LEDA\\src\\database";

        Tweet[] database = extract_database(dir_tweets_database);
        write_date_file(dir_project_database, "tweets_formatted_date", database);
        write_mentioned_persons_file(dir_project_database, "tweets_mentioned_persons", database);
    }

    public static Tweet[] extract_database(String dir){
        String path = dir + File.separator + "tweets.csv";
        int lines = 1600000;
        Tweet[] database = new Tweet[lines];
        
        try (BufferedReader file = new BufferedReader(new FileReader(path))){
            System.out.println("Extracting database...");
            String line;
            int i = 0;
            while((line = file.readLine()) != null){
                if(i > 0){ //pulando a linha incial de cabeçalho
                    String[] field =  line.split(","); //separando a linha em campos
                    int target = Integer.parseInt(field[0]);
                    long id = Long.parseLong(field[1]);
        
                    Tweet tweet = new Tweet(target, id, field[2], field[3], field[4], field[5].trim());
                    database[i-1] = tweet;
                }
                i++;
            }
            System.out.println("Extract database completed.");
        } catch (IOException e) {
            System.out.println("Error extracting data.");
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("Error converting number.");
            e.printStackTrace();
        }
        return database;
    }

    public static void write_date_file(String dir, String file_name, Tweet[] data){
        String path = dir + File.separator + file_name + ".csv";

        try (BufferedWriter file = new BufferedWriter(new FileWriter(path))){
            System.out.println("Saving by formatted date...");
			file.write("Target,ID,Date,flag,User,Text");
            file.newLine();

            int i = 0;
            while (data[i] != null) {
                String line = String.format("%s,%s,%s,%s,%s,%s", 
                    data[i].getTarget(), 
                    data[i].getId(), 
                    data[i].getFormatted_date(), 
                    data[i].getFlag(), 
                    data[i].getUser(), 
                    data[i].getText()
                );
                file.write(line);
                file.newLine();
                i++;
            }
            System.out.println("Information saved by data.");
        } catch (IOException e){
			System.out.println("Error writing file.");
			e.printStackTrace();
        }
    }

    public static void write_mentioned_persons_file(String dir, String file_name, Tweet[] data){
        String path_formatted_date = dir + File.separator + "tweets_formatted_date.csv";
        String path_mentioned_persons = dir + File.separator + file_name + ".csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(path_formatted_date));
             BufferedWriter writer = new BufferedWriter(new FileWriter(path_mentioned_persons))) {

            System.out.println("Saving data with mentioned persons...");
			String header = reader.readLine();
            writer.write(header + ",Mentioned_persons,Mentioned_persons_count");
            writer.newLine();

            int i = 1; //pulando o cabeçalho
            String line;
            while ((line = reader.readLine()) != null && data[i] != null) {
                writer.write(line + "," + 
                             data[i-1].getMentioned_person() + "," + 
                             data[i-1].getMentioned_person_count());
                writer.newLine();
                i++;
            }
            System.out.println("Information saved with mentioned persons.");
        } catch (IOException e){
			System.out.println("Error processing file.");
			e.printStackTrace();
        }
    }

    public static void printArray(Tweet[] database, int quantity){
        for (int i = 0; i < quantity; i++){
            System.out.println(database[i]);
        }
    }
}
