package InsertionSort;

import java.util.Random;

public class CasoMedio100000 {
    public static void main(String[] args) {
        // Criando um array de 100.000 elementos com valores aleatórios (caso médio)
        int n = 100000;
        int[] array = new int[n];
        Random random = new Random();

        // Preenchendo o array com valores aleatórios
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n); // Números aleatórios entre 0 e 99.999
        }

        long startTime = System.nanoTime();

        // Chamada do Insertion Sort
        insertionSort(array);

        long endTime = System.nanoTime();

        // Calculando o tempo em milissegundos
        double durationInMilliseconds = (endTime - startTime) / 1_000_000.0;

        // Exibindo o tempo de execução, comparações e trocas
        System.out.println("Tempo de Execução: " + durationInMilliseconds + " ms");
        System.out.println("Comparações: " + comparisons);
        System.out.println("Trocas: " + swaps);
    }

    // Variáveis globais para contar comparações e trocas
    static long comparisons = 0;
    static long swaps = 0;

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Comparações para encontrar a posição correta
            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j--;
                swaps++; // Contando os deslocamentos como trocas
            }

            comparisons++; // Para a última comparação que falha
            arr[j + 1] = key;
        }
    }
}
