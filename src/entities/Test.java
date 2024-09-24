package entities;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test {
    private long initialTime;
    private long endTime;
    private long duration;
    private long initialMemory;
    private long finalMemory;
    private long memory;


    public void startTest(){
        System.out.printf("Initial time: %s\n", showTime());
        this.initialTime = System.currentTimeMillis(); 
        this.initialMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); 
    }

    public void endTest() {
        System.out.printf("End Time: %s\n", showTime());
        this.endTime = System.currentTimeMillis();
        this.finalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); 
        this.duration = endTime - initialTime; 
        this.memory = finalMemory - initialMemory; 
    }

    public void showResult() {
        System.out.println("Tempo de execução: " + duration + " ms");
        System.out.println("Memória utilizada: " + memory / (1024 * 1024) + " MB");
        System.out.println(); 
    }

    public String showTime(){
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formatted_time = now.format(formatter);
        return formatted_time;
    }
}