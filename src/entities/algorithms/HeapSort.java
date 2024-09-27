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
    
        // Verificar o filho da esquerda
        if (left < n) {
            if (array[left].getYear() > array[largest].getYear() || 
                (array[left].getYear() == array[largest].getYear() && array[left].getMonth() > array[largest].getMonth()) ||
                (array[left].getYear() == array[largest].getYear() && array[left].getMonth() == array[largest].getMonth() && array[left].getDay() > array[largest].getDay())) {
                    largest = left;
            }
        }
    
        // Verificar o filho da direita
        if (right < n) {
            if (array[right].getYear() > array[largest].getYear() || 
                (array[right].getYear() == array[largest].getYear() && array[right].getMonth() > array[largest].getMonth()) ||
                (array[right].getYear() == array[largest].getYear() && array[right].getMonth() == array[largest].getMonth() && array[right].getDay() > array[largest].getDay())) {
                    largest = right;
            }
        }
    
        // Troca se necessário
        if (largest != i) {
            Tweet swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
    
            // Recursão para garantir que a subárvore está em heap
            heapByDate(array, n, largest);
        }
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
