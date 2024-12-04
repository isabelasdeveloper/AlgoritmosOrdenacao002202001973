package BubbleSort;

import java.util.Random;

public class CasoMedio10000 {

    // Contadores para comparações e trocas
    static int comparacoes = 0;
    static int trocas = 0;

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparacoes++; // Cada comparação
                if (arr[j] > arr[j + 1]) {
                    // Troca de elementos
                    trocas++; // Cada troca
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Se nenhuma troca foi feita, o vetor já está ordenado
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        // Vetor de 10.000 elementos com números aleatórios
        int[] arr = new int[10000];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000); // Números aleatórios entre 0 e 9999
        }

        // Medir o tempo de execução
        long startTime = System.nanoTime();
        bubbleSort(arr);
        long endTime = System.nanoTime();

        // Tempo de execução em milissegundos
        System.out.printf("Tempo de execução: %.5f ms%n", (endTime - startTime) / 1e6);

        // Imprimir as métricas
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
    }
}


