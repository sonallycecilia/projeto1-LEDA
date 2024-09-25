import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entities.Test;
import entities.Tweet;
import entities.algorithms.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String dir_tweets_database = "C:\\Users\\sonal\\Documents\\vs projects\\databaseTweets";
        String dir_project_database = "C:\\Users\\sonal\\Documents\\vs projects\\projeto1-LEDA\\src\\database";

        Tweet[] database;
        
        database = extract_tweets_database(dir_tweets_database);
        write_date_file(dir_project_database, "tweets_formatted_date", database);
        write_mentioned_persons_file(dir_project_database, "tweets_mentioned_persons", database);
        database = null;

        /* 
        Tweet[] teste = extract_test(dir_project_database, "tweets_teste");
        SelectionSort.sortByMentionedCount(teste);
        write_ordened_file(dir_project_database, "ex", teste);
        */
        /* 
        //CountingSort medio, melhor e pior caso (date)
        database = extract_database(dir_project_database, "tweets_mentioned_persons");
        CountingSort.sortByDate(database); //medio caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_date_countingSort_medioCaso", database);
        CountingSort.sortByDate(database); //melhor caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_date_countingSort_melhorCaso", database);
        MergeSort.mergeByReverseDate(database); //gerando pior caso
        CountingSort.sortByDate(database); //pior caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_date_countingSort_piorCaso", database);
        database = null;
        */

        //CountingSort medio, melhor e pior caso (count)
        database = extract_database(dir_project_database, "tweets_mentioned_persons");
        CountingSort.sortByMentionedCount(database); //medio caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_count_countingSort_medioCaso", database);
        CountingSort.sortByMentionedCount(database); //melhor caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_count_countingSort_melhorCaso", database);
        MergeSort.mergeByReverseDate(database); //gerando pior caso
        CountingSort.sortByMentionedCount(database); //pior caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_count_countingSort_piorCaso", database);
        database = null;
        
        /* 
        //HeapSort medio, melhor e pior caso (date)
        database = extract_database(dir_project_database, "tweets_mentioned_persons");
        HeapSort.sortByDate(database); //medio caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_date_heapSort_medioCaso", database);
        HeapSort.sortByDate(database); //melhor caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_date_heapSort_melhorCaso", database);
        MergeSort.mergeByReverseDate(database); //gerando pior caso
        HeapSort.sortByDate(database); //pior caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_date_heapSort_piorCaso", database);
        database = null;
        
        //HeapSort medio, melhor e pior caso (count)
        database = extract_database(dir_project_database, "tweets_mentioned_persons");
        HeapSort.sortByMentionedCount(database); //medio caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_count_heapSort_medioCaso", database);
        HeapSort.sortByMentionedCount(database); //melhor caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_count_heapSort_melhorCaso", database);
        MergeSort.mergeByReverseMentionedCount(database); //gerando pior caso
        HeapSort.sortByMentionedCount(database); //pior caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_count_heapSort_piorCaso", database);
        database = null;
        
        //HeapSort medio, melhor e pior caso (user)
        database = extract_database(dir_project_database, "tweets_mentioned_persons");
        HeapSort.sortByUser(database); //medio caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_user_heapSort_medioCaso", database);
        HeapSort.sortByUser(database); //melhor caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_user_heapSort_melhorCaso", database);
        MergeSort.mergeByReverseUser(database); //gerando pior caso
        HeapSort.sortByUser(database); //pior caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_user_heapSort_piorCaso", database);
        database = null;
        
        //MergeSort medio, melhor e pior caso (date)
        database = extract_database(dir_project_database, "tweets_mentioned_persons");
        MergeSort.mergeByDate(database); //medio caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_date_mergeSort_medioCaso", database);
        MergeSort.mergeByDate(database); //melhor caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_date_mergeSort_melhorCaso", database);
        MergeSort.mergeByReverseDate(database); //gerando pior caso
        MergeSort.mergeByDate(database); //pior caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_date_mergeSort_piorCaso", database);
        database = null;
        
        //MergeSort medio, melhor e pior caso (count)
        database = extract_database(dir_project_database, "tweets_mentioned_persons");
        MergeSort.mergeByMentionedCount(database); //medio caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_count_mergeSort_medioCaso", database);
        MergeSort.mergeByMentionedCount(database); //melhor caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_count_mergeSort_melhorCaso", database);
        MergeSort.mergeByReverseMentionedCount(database); //gerando pior caso
        MergeSort.mergeByMentionedCount(database); //pior caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_count_mergeSort_piorCaso", database);
        database = null;
        
        //MergeSort medio, melhor e pior caso (user)
        database = extract_database(dir_project_database, "tweets_mentioned_persons");
        MergeSort.mergeByUser(database); //medio caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_user_mergeSort_medioCaso", database);
        MergeSort.mergeByUser(database); //melhor caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_user_mergeSort_melhorCaso", database);
        MergeSort.mergeByReverseUser(database); //gerando pior caso
        MergeSort.mergeByUser(database); //pior caso
        write_ordened_file(dir_project_database, "tweets_mentioned_persons_user_mergeSort_piorCaso", database);
        database = null;
        */
    }

    public static Tweet[] extract_tweets_database(String dir){
        String path = dir + File.separator + "tweets.csv";
        int lines = 1048575;
        Tweet[] database = new Tweet[lines];
        
        try (BufferedReader file = new BufferedReader(new FileReader(path))){
            System.out.println("Extracting database...");
            String line;
            int i = 0;
            while((line = file.readLine()) != null){
                if(i > 0){ //pulando a linha incial de cabeçalho
                    String[] field =  line.split(","); //separando a linha em campos
                    Tweet tweet = new Tweet(field[0], field[1], field[2], field[3], field[4], field[5].trim());
                    database[i-1] = tweet;
                }
                i++;
            }
            System.out.println("Extract database completed.");
        } catch (IOException e) {
            System.out.println("Error extracting data.");
            e.printStackTrace();
        }
        return database;
    }

    public static Tweet[] extract_database(String dir, String name){
        String path = dir + File.separator + name + ".csv";
        int lines = 1048575;
        Tweet[] database = new Tweet[lines]; 

        try (BufferedReader file = new BufferedReader(new FileReader(path))) {
            String line;
            int i = 0;
            
            while ((line = file.readLine()) != null) {
                if (i > 0) { // pulando a linha inicial de cabeçalho
                    String[] field = line.split(","); // separando a linha em campos
                    
                    int count_mentioned_person = 0;
                    try {
                        count_mentioned_person = Integer.parseInt(field[7]);
                    } catch (NumberFormatException e) {
                        System.out.println("Error converting number.");
                        e.printStackTrace();
                    }
                    
                    Tweet tweet = new Tweet(field[0], field[1], field[2], field[3], field[4], field[5], field[6], count_mentioned_person);
                    database[i - 1] = tweet;
                }
                i++;
            }
        } catch (IOException e) {
            System.out.println("Error extracting data.");
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

            for(int i = 0; i < data.length; i++) {
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
			

            int i = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if(i == 0){
                    writer.write(line + ",Mentioned_persons,Mentioned_persons_count");
                    writer.newLine();
                } else{
                    if (i - 1 < data.length && data[i - 1] != null) {
                        writer.write(line + "," +
                                     data[i - 1].getMentioned_person() + "," +
                                     data[i - 1].getMentioned_person_count());
                        writer.newLine();
                    }
                }
                i++;
            }
            System.out.println("Information saved with mentioned persons.");
        } catch (IOException e){
			System.out.println("Error processing file.");
			e.printStackTrace();
        }
    }

    public static void write_ordened_file(String dir, String name, Tweet[] data){
        String path = dir + File.separator + "ordened_database" + File.separator + name + ".csv";

        try (BufferedWriter file = new BufferedWriter(new FileWriter(path))){
			file.write("Target,ID,Date,flag,User,Text");
            file.newLine();

            int i = 0;
            while (i < data.length && data[i] != null) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%d", 
                    data[i].getTarget(), 
                    data[i].getId(), 
                    data[i].getFormatted_date(), 
                    data[i].getFlag(), 
                    data[i].getUser(), 
                    data[i].getText(),
                    data[i].getMentioned_person(),
                    data[i].getMentioned_person_count()
                );
                file.write(line);
                file.newLine();
                i++;
            }
        } catch (IOException e){
			System.out.println("Error writing file.");
			e.printStackTrace();
        }
    }

    public static Tweet[] extract_test(String dir, String name){
        String path = dir + File.separator + name + ".csv";
        int lines = 295;
        Tweet[] database = new Tweet[lines]; 

        try (BufferedReader file = new BufferedReader(new FileReader(path))) {
            System.out.println("Extracting test database...");
            String line;
            int i = 0;
            
            while ((line = file.readLine()) != null) {
                if (i > 0) { // pulando a linha inicial de cabeçalho
                    String[] field = line.split(","); // separando a linha em campos
                    
                    int count_mentioned_person = 0;
                    try {
                        count_mentioned_person = Integer.parseInt(field[7]);
                    } catch (NumberFormatException e) {
                        System.out.println("Error converting number.");
                        e.printStackTrace();
                    }
                    
                    Tweet tweet = new Tweet(field[0], field[1], field[2], field[3], field[4], field[5], field[6], count_mentioned_person);
                    database[i - 1] = tweet;
                }
                i++;
            }
            System.out.println("Extract test database completed.");
        } catch (IOException e) {
            System.out.println("Error extracting data test.");
            e.printStackTrace();
        }

        return database;
    }

}
