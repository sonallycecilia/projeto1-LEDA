package entities.algorithms;

import entities.Tweet;

public class HeapSort {
    
    public static void sortByDate(Tweet[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapByDate(array, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            Tweet temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapByDate(array, i, 0);
        }
    }

    private static void heapByDate(Tweet[] array, int n, int i) {
        int largest = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 

        if (left < n && compareDate(array[left], array[largest])) {
            largest = left;
        }
        if (right < n && compareDate(array[right], array[largest])) {
            largest = right;
        }
        if (largest != i) {
            Tweet swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapByDate(array, n, largest);
        }
    }

    private static boolean compareDate(Tweet tweet1, Tweet tweet2) {
        String[] date1Parts = tweet1.getFormatted_date().split("/");
        int day1 = Integer.parseInt(date1Parts[0]);
        int month1 = Integer.parseInt(date1Parts[1]);
        int year1 = Integer.parseInt(date1Parts[2]);

        String[] date2Parts = tweet2.getFormatted_date().split("/");
        int day2 = Integer.parseInt(date2Parts[0]);
        int month2 = Integer.parseInt(date2Parts[1]);
        int year2 = Integer.parseInt(date2Parts[2]);

        if (year1 > year2) {
            return true;
        } else if (year1 == year2) {
            if (month1 > month2) {
                return true;
            } else if (month1 == month2) {
                return day1 > day2;
            }
        }
        return false;
    }

    public static void sortByMentionedCount(Tweet[] array) {
        int n = array.length;

        // Constrói o heap (rearranja o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapByMentionedCount(array, n, i);
        }

        // Extrai os elementos do heap um por um
        for (int i = n - 1; i >= 0; i--) {
            // Move o maior valor (na raiz) para o final do array
            Tweet temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Chama heapify no heap reduzido
            heapByMentionedCount(array, i, 0);
        }
    }

    private static void heapByMentionedCount(Tweet[] array, int n, int i) {
        int largest = i;  // Inicializa o maior como raiz
        int left = 2 * i + 1;  // Filho à esquerda
        int right = 2 * i + 2;  // Filho à direita

        // Se o filho à esquerda existe e o número de menções à esquerda for maior
        if (left < n && array[left].getMentioned_person_count() < array[largest].getMentioned_person_count()) {
            largest = left;
        }

        // Se o filho à direita existe e o número de menções à direita for maior
        if (right < n && array[right].getMentioned_person_count() < array[largest].getMentioned_person_count()) {
            largest = right;
        }

        // Se o maior não for a raiz, troca os elementos
        if (largest != i) {
            Tweet swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursivamente faz heapify no sub-heap afetado
            heapByMentionedCount(array, n, largest);
        }
    }

    public static void sortByUser(Tweet[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapByUser(array, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            Tweet temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapByUser(array, i, 0);
        }
    }

    private static void heapByUser(Tweet[] array, int n, int i) {
        int largest = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 

        if (left < n && array[left].getUser().compareTo(array[largest].getUser()) > 0) {
            largest = left;
        }

        if (right < n && array[right].getUser().compareTo(array[largest].getUser()) > 0) {
            largest = right;
        }

        if (largest != i) {
            Tweet swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heapByUser(array, n, largest);
        }
    }

}
