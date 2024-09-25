package entities.algorithms;

import entities.Tweet;

public class QuickSort {

    public static void sortByDate(Tweet[] vetor, int inicio, int fim) {
        // Verifica se o intervalo é válido para evitar partições inválidas
        if (inicio < fim) {
            int pivo = partitionByDate(vetor, inicio, fim);
            sortByDate(vetor, inicio, pivo);   // Chama recursivamente para a primeira partição
            sortByDate(vetor, pivo + 1, fim);  // Chama recursivamente para a segunda partição
        }
    }

    private static int partitionByDate(Tweet[] vetor, int esquerda, int direita) {
        // Escolhe o pivô como o elemento do meio
        Tweet pivo = vetor[(esquerda + direita) / 2];
        int i = esquerda;
        int j = direita;

        while (i <= j) {
            // Avança o índice i enquanto o elemento for menor que o pivô
            while (compareDate(vetor[i].getFormatted_date(), pivo.getFormatted_date()) < 0) {
                i++;
            }

            // Retrocede o índice j enquanto o elemento for maior que o pivô
            while (compareDate(vetor[j].getFormatted_date(), pivo.getFormatted_date()) > 0) {
                j--;
            }

            // Se i e j ainda não se cruzaram, troque os elementos
            if (i <= j) {
                Tweet aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
                i++;
                j--;
            }
        }

        return j; // Retorna a posição correta do pivô
    }

    private static int compareDate(String date1, String date2) {
        String[] d1 = date1.split("/");
        String[] d2 = date2.split("/");

        int year1 = Integer.parseInt(d1[0]);
        int year2 = Integer.parseInt(d2[0]);
        if (year1 != year2) {
            return Integer.compare(year1, year2);
        }

        int month1 = Integer.parseInt(d1[1]);
        int month2 = Integer.parseInt(d2[1]);
        if (month1 != month2) {
            return Integer.compare(month1, month2);
        }

        int day1 = Integer.parseInt(d1[2]);
        int day2 = Integer.parseInt(d2[2]);
        return Integer.compare(day1, day2);
    }
}
