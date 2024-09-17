import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        String dir = "C:\\Users\\sonal\\Documents\\vs projects\\projeto1-LEDA\\main\\src\\database";

        String[] array = read_dataset(dir);
        printArray(array, 100);
        
    }

    public static String[] read_dataset(String dir){
        String path = dir + File.separator + "tweets.csv";
        int lines = 1500000;
        String[] array = new String[lines];
        
        try (BufferedReader file = new BufferedReader(new FileReader(path))){
            String line;
            int i = 0;
            while((line = file.readLine()) != null){
                array[i] = line;
                i++;
            }
        } catch (IOException e) {
            System.out.println("Error extracting data");
            e.printStackTrace();
        }
        return array;
    }

    public static void printArray(String[] array, int qtd){
        for (int i = 0; i < qtd; i++){
            System.out.printf("%s\n", array[i]);
            System.out.printf("%d\n", i);
        }
    }
}
