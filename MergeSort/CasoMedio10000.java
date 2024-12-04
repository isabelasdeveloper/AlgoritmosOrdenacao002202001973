package MergeSort;

import java.util.Random;

public class CasoMedio10000 {

    public static int comparisons = 0; // Contador de comparações
    public static int swaps = 0; // Contador de trocas

    public static void main(String[] args) {
        int n = 10000; // Número de elementos
        int[] array = new int[n];

        // Preenchendo o array com valores aleatórios (Caso Médio)
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(10000); // Números aleatórios de 0 a 9999
        }

        long startTime = System.nanoTime();

        // Merge Sort
        mergeSort(array, 0, n - 1);

        long endTime = System.nanoTime();

        // Calculando o tempo em milissegundos
        double durationInMilliseconds = (endTime - startTime) / 1_000_000.0;

        // Exibindo resultados
        System.out.println("Tempo de Execução: " + durationInMilliseconds + " ms");
        System.out.println("Comparações: " + comparisons);
        System.out.println("Trocas: " + swaps);
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid); // Recursão para a metade esquerda
            mergeSort(array, mid + 1, right); // Recursão para a metade direita

            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Arrays temporários para armazenar as sublistas
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            comparisons++; // Contando as comparações
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copiar os elementos restantes
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
            swaps++; // Contando as trocas
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
            swaps++; // Contando as trocas
        }
    }
}
