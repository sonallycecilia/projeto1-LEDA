import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        String dir_database = "C:\\Users\\sonal\\Documents\\vs projects\\databaseTweets";

        String[][] database = read_dataset(dir_database);
        printArray(database, 10);
        
    }

    public static String[][] read_dataset(String dir){
        String path = dir + File.separator + "tweets.csv";
        int lines = 1600000;
        int fields = 6;
        String[][] database = new String[lines][fields];
        
        try (BufferedReader file = new BufferedReader(new FileReader(path))){
            String line;
            int i = 0;
            while((line = file.readLine()) != null){
                String[] tweet =  line.split(",");
                database[i] = tweet;
                i++;
            }
        } catch (IOException e) {
            System.out.println("Error extracting data");
            e.printStackTrace();
        }
        return database;
    }

    public static void write_ordened_data(String dir){

    }

    public static void printArray(String[][] database, int quantity){
        for (int i = 0; i < quantity; i++){
            for (int j = 0; j < database[i].length; j++){
                System.out.printf("%s\n", database[i][j]);
            }
            System.out.println();
        }
    }
}
