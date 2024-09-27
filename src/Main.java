import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import utils.Tweet;
import algorithms.*;

public class Main {
    
    public static final String DIR_TWEETS_DATABASE = "C:\\Users\\sonal\\Documents\\vs projects\\databaseTweets";
    
    public static final String DIR_PROJECT_DATABASE = System.getProperty("user.dir") + File.separator + "src" + File.separator + "database";

    public static final int DATABASE_LENGTH = 1048575;
    
    public static void main(String[] args) throws Exception {
        Tweet[] database;

        database = extract_tweets_database(DIR_TWEETS_DATABASE);
        System.out.println("Writing formatted files...");
        write_date_file("tweets_formatted_date", database);
        write_mentioned_persons_file("tweets_mentioned_persons", database);
        database = null;

        //#01 | CountingSort | Date | Médio, melhor e pior cenário
        System.out.println("#01 | CountingSort | Date -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        CountingSort.sortByDate(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_date_countingSort_medioCaso", database);
        CountingSort.sortByDate(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_date_countingSort_melhorCaso", database);
        MergeSort.mergeByReverseDate(database); //gerando pior caso
        CountingSort.sortByDate(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_date_countingSort_piorCaso", database);
        database = null;
     
        //#02 | CountingSort | Count | Médio, melhor e pior cenário
        System.out.println("#02 | CountingSort | Count -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        CountingSort.sortByMentionedCount(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_count_countingSort_medioCaso", database);
        CountingSort.sortByMentionedCount(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_count_countingSort_melhorCaso", database);
        MergeSort.mergeByReverseDate(database); //gerando pior caso
        CountingSort.sortByMentionedCount(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_count_countingSort_piorCaso", database);
        database = null;

        //#03 | HeapSort | Date | Médio, melhor e pior cenário
        System.out.println("#03 | HeapSort | Date -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        HeapSort.sortByDate(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_date_heapSort_medioCaso", database);
        HeapSort.sortByDate(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_date_heapSort_melhorCaso", database);
        MergeSort.mergeByReverseDate(database); //gerando pior caso
        HeapSort.sortByDate(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_date_heapSort_piorCaso", database);
        database = null;

        //#04 | HeapSort | Count | Médio, melhor e pior cenário
        System.out.println("#04 | HeapSort | Count -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        HeapSort.sortByMentionedCount(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_count_heapSort_medioCaso", database);
        HeapSort.sortByMentionedCount(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_count_heapSort_melhorCaso", database);
        MergeSort.mergeByReverseMentionedCount(database); //gerando pior caso
        HeapSort.sortByMentionedCount(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_count_heapSort_piorCaso", database);
        database = null;

        //#05 | HeapSort | User | Médio, melhor e pior cenário
        System.out.println("#05 | HeapSort | User -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        HeapSort.sortByUser(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_user_heapSort_medioCaso", database);
        HeapSort.sortByUser(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_user_heapSort_melhorCaso", database);
        MergeSort.mergeByReverseUser(database); //gerando pior caso
        HeapSort.sortByUser(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_user_heapSort_piorCaso", database);
        database = null;

        //#06 | InsertionSort | Date | Médio, melhor e pior cenário
        System.out.println("#06 | InsertionSort | Date -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        InsertionSort.sortByDate(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_date_insertionSort_medioCaso", database);
        InsertionSort.sortByDate(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_date_insertionSort_melhorCaso", database);
        MergeSort.mergeByReverseDate(database); //gerando pior caso
        InsertionSort.sortByDate(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_date_insertionSort_piorCaso", database);
        database = null;

        //#07 | InsertionSort | Count | Médio, melhor e pior cenário
        System.out.println("#07 | InsertionSort | Count -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        InsertionSort.sortByMentionedCount(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_count_insertionSort_medioCaso", database);
        InsertionSort.sortByMentionedCount(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_count_insertionSort_melhorCaso", database);
        MergeSort.mergeByReverseMentionedCount(database); //gerando pior caso
        InsertionSort.sortByMentionedCount(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_count_insertionSort_piorCaso", database);
        database = null;
        
        //#08 | InsertionSort | User | Médio, melhor e pior cenário
        System.out.println("#08 | InsertionSort | User -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        InsertionSort.sortByUser(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_user_insertionSort_medioCaso", database);
        InsertionSort.sortByUser(database); //melhor caso]
        write_ordened_file("tweets_mentioned_persons_user_insertionSort_melhorCaso", database);
        MergeSort.mergeByReverseUser(database); //gerando pior caso
        InsertionSort.sortByUser(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_user_insertionSort_piorCaso", database);
        database = null;

        //#09 | MergeSort | Date | Médio, melhor e pior cenário
        System.out.println("#09 | MergeSort | Date -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        MergeSort.mergeByDate(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_date_mergeSort_medioCaso", database);
        MergeSort.mergeByDate(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_date_mergeSort_melhorCaso", database);
        MergeSort.mergeByReverseDate(database); //gerando pior caso
        MergeSort.mergeByDate(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_date_mergeSort_piorCaso", database);
        database = null;
        
        //#10 | MergeSort | Count | Médio, melhor e pior cenário
        System.out.println("#10 | MergeSort | Count -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        MergeSort.mergeByMentionedCount(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_count_mergeSort_medioCaso", database);
        MergeSort.mergeByMentionedCount(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_count_mergeSort_melhorCaso", database);
        MergeSort.mergeByReverseMentionedCount(database); //gerando pior caso
        MergeSort.mergeByMentionedCount(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_count_mergeSort_piorCaso", database);
        database = null;
        
        //#11 | MergeSort | User | Médio, melhor e pior cenário
        System.out.println("#11 | MergeSort | User -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        MergeSort.mergeByUser(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_user_mergeSort_medioCaso", database);
        MergeSort.mergeByUser(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_user_mergeSort_melhorCaso", database);
        MergeSort.mergeByReverseUser(database); //gerando pior caso
        MergeSort.mergeByUser(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_user_mergeSort_piorCaso", database);
        database = null;
        
        //#12 | QuickSort | Date - Média | Médio, melhor e pior cenário
        System.out.println("#12 | QuickSort | Date - Average -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        QuickSort.sortByAverageDateIterative(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_date_quickSort(media)_medioCaso", database);
        QuickSort.sortByAverageDateIterative(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_date_quickSort(media)_melhorCaso", database);
        MergeSort.mergeByReverseDate(database); //gerando pior caso
        QuickSort.sortByAverageDateIterative(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_date_quickSort(media)_piorCaso", database);
        database = null;

        //#13 | QuickSort | Count - Média | Médio, melhor e pior cenário
        System.out.println("#13 | QuickSort | Count - Average -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        QuickSort.sortByAverageMentionedCountIterative(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_count_quickSort(media)_medioCaso", database);
        QuickSort.sortByAverageMentionedCountIterative(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_count_quickSort(media)_melhorCaso", database);
        MergeSort.mergeByReverseDate(database); //gerando pior caso
        QuickSort.sortByAverageMentionedCountIterative(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_count_quickSort(media)_piorCaso", database);
        database = null;
        
        //#14 | QuickSort | Date | Médio, melhor e pior cenário
        System.out.println("#14 | QuickSort | Date -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        QuickSort.sortByDateIterative(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_date_quickSort_medioCaso", database);
        QuickSort.sortByDateIterative(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_date_quickSort_melhorCaso", database);
        MergeSort.mergeByReverseDate(database); //gerando pior caso
        QuickSort.sortByDateIterative(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_date_quickSort_piorCaso", database);
        database = null;

        //#14 | QuickSort | Count | Médio, melhor e pior cenário
        System.out.println("#14 | QuickSort | Count -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        QuickSort.sortByMentionedCountIterative(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_count_quickSort_medioCaso", database);
        QuickSort.sortByMentionedCountIterative(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_count_quickSort_melhorCaso", database);
        MergeSort.mergeByReverseDate(database); //gerando pior caso
        QuickSort.sortByMentionedCountIterative(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_count_quickSort_piorCaso", database);
        database = null;

        //#15 | QuickSort | User | Médio, melhor e pior cenário
        System.out.println("#15 | QuickSort | User -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        QuickSort.sortByUserIterative(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_user_quickSort(iterativo)_medioCaso", database);
        QuickSort.sortByUserIterative(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_user_quickSor(iterativo)_melhorCaso", database);
        MergeSort.mergeByReverseDate(database); //gerando pior caso
        QuickSort.sortByUserIterative(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_user_quickSort(iterativo)_piorCaso", database);
        database = null;
        
        //#16 | SelectionSort | Date | Médio, melhor e pior cenário
        System.out.println("#16 | SelectionSort | Date -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        SelectionSort.sortByDate(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_date_selectionSort_medioCaso", database);
        SelectionSort.sortByDate(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_date_selectionSort_melhorCaso", database);
        MergeSort.mergeByReverseDate(database); //gerando pior caso
        SelectionSort.sortByDate(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_date_selectionSort_piorCaso", database);
        database = null;

        //#17 | SelectionSort | Count | Médio, melhor e pior cenário
        System.out.println("#17 | SelectionSort | Count -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        SelectionSort.sortByMentionedCount(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_count_selectionSort_medioCaso", database);
        SelectionSort.sortByMentionedCount(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_count_selectionSort_melhorCaso", database);
        MergeSort.mergeByReverseMentionedCount(database); //gerando pior caso
        SelectionSort.sortByMentionedCount(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_count_selectionSort_piorCaso", database);
        database = null;

        //#18 | SelectionSort | User | Médio, melhor e pior cenário
        System.out.println("#18 | SelectionSort | User -> generating files...");
        database = extract_database("tweets_mentioned_persons");
        SelectionSort.sortByUser(database); //medio caso
        write_ordened_file("tweets_mentioned_persons_user_selectionSort_medioCaso", database);
        SelectionSort.sortByUser(database); //melhor caso
        write_ordened_file("tweets_mentioned_persons_user_selectionSort_melhorCaso", database);
        MergeSort.mergeByReverseUser(database); //gerando pior caso
        SelectionSort.sortByUser(database); //pior caso
        write_ordened_file("tweets_mentioned_persons_user_selectionSort_piorCaso", database);
        database = null;

    }

    public static Tweet[] extract_tweets_database(String dir){
        String path = dir + File.separator + "tweets.csv";
        int lines = DATABASE_LENGTH;
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

    public static Tweet[] extract_database(String name){
        String path = DIR_PROJECT_DATABASE + File.separator + name + ".csv";
        int lines = DATABASE_LENGTH;
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

    public static void write_date_file(String file_name, Tweet[] data){
        String path = DIR_PROJECT_DATABASE + File.separator + file_name + ".csv";

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

    public static void write_mentioned_persons_file(String file_name, Tweet[] data){
        String path_formatted_date = DIR_PROJECT_DATABASE + File.separator + "tweets_formatted_date.csv";
        String path_mentioned_persons = DIR_PROJECT_DATABASE + File.separator + file_name + ".csv";

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

    public static void write_ordened_file(String name, Tweet[] data){
        String path = DIR_PROJECT_DATABASE + File.separator + "ordened_database" + File.separator + name + ".csv";

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
    
}
