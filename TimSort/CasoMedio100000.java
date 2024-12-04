package TimSort;

import java.util.Arrays;
import java.util.Random;

public class CasoMedio100000 {

    // Classe personalizada para rastrear comparações e trocas
    static class TrackableArray implements Comparable<TrackableArray> {
        static int comparisons = 0;
        static int swaps = 0;

        int value;

        TrackableArray(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(TrackableArray other) {
            comparisons++; // Contando as comparações
            return Integer.compare(this.value, other.value);
        }

        static void resetCounters() {
            comparisons = 0;
            swaps = 0;
        }

        static void swap(TrackableArray[] arr, int i, int j) {
            swaps++; // Contando as trocas
            TrackableArray temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int n = 100000; // Número de elementos
        TrackableArray[] array = new TrackableArray[n];
        Random random = new Random();

        // Preenchendo o array com valores aleatórios (caso médio)
        for (int i = 0; i < n; i++) {
            array[i] = new TrackableArray(random.nextInt(n));
        }

        // Resetando contadores de comparações e trocas
        TrackableArray.resetCounters();

        long startTime = System.nanoTime();

        // Ordenando com Timsort (Arrays.sort)
        Arrays.sort(array);

        long endTime = System.nanoTime();

        // Calculando o tempo em milissegundos
        double durationInMilliseconds = (endTime - startTime) / 1_000_000.0;

        // Exibindo resultados
        System.out.println("Tempo de Execução: " + durationInMilliseconds + " ms");
        System.out.println("Comparações: " + TrackableArray.comparisons);
        System.out.println("Trocas: " + TrackableArray.swaps);
    }
}
