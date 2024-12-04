package SelectionSort;

public class PiorCaso1000 {

    public static void main(String[] args) {
        int n = 1000; // Número de elementos
        int[] array = new int[n];

        // Preenchendo o array com valores em ordem decrescente (pior caso)
        for (int i = 0; i < n; i++) {
            array[i] = n - i; // Ordem decrescente
        }

        long startTime = System.nanoTime();

        // Contando comparações e trocas
        int comparisons = 0;
        int swaps = 0;

        // Selection Sort
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++; // Contando as comparações
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Troca
            if (minIndex != i) {
                swaps++; // Contando as trocas
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

        long endTime = System.nanoTime();

        // Calculando o tempo em milissegundos
        double durationInMilliseconds = (endTime - startTime) / 1_000_000.0;

        // Exibindo resultados
        System.out.println("Tempo de Execução: " + durationInMilliseconds + " ms");
        System.out.println("Comparações: " + comparisons);
        System.out.println("Trocas: " + swaps);
    }
}
