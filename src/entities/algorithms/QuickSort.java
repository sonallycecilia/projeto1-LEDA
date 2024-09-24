package entities.algorithms;

import entities.Tweet;

public class QuickSort {
    
    public static void sortByDate(Tweet[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = partitionByDate(vetor, inicio, fim);
            sortByDate(vetor, inicio, pivo);       
            sortByDate(vetor, pivo + 1, fim);    
        }
    }

    private static int partitionByDate(Tweet[] vetor, int esquerda, int direita) {
        Tweet pivo = vetor[(esquerda + direita) / 2];
        int i = esquerda - 1;
        int j = direita + 1;

        while (true) {
            do {
                i++;
            } while (compareDate(vetor[i].getFormatted_date(), pivo.getFormatted_date()) < 0);

            do {
                j--;
            } while (compareDate(vetor[j].getFormatted_date(), pivo.getFormatted_date()) > 0);

            if (i >= j) {
                return j;
            }

            Tweet aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }

    private static int compareDate(String date1, String date2) {
        String[] d1 = date1.split("/");
        String[] d2 = date2.split("/");

        int year1 = Integer.parseInt(d1[0]);
        int month1 = Integer.parseInt(d1[1]);
        int day1 = Integer.parseInt(d1[2]);

        int year2 = Integer.parseInt(d2[0]);
        int month2 = Integer.parseInt(d2[1]);
        int day2 = Integer.parseInt(d2[2]);

        if (year1 != year2) return Integer.compare(year1, year2);
        if (month1 != month2) return Integer.compare(month1, month2);
        return Integer.compare(day1, day2);
    }

}
