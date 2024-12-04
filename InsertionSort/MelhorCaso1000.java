package InsertionSort;

public class MelhorCaso1000 {
    public static void main(String[] args) {
        // Criando um array de 1000 elementos no melhor caso (array já ordenado)
        int n = 1000;
        int[] array = new int[n];

        // Preenchendo o array de forma crescente (melhor caso)
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        long startTime = System.nanoTime();

        // Chamada do Insertion Sort
        insertionSort(array);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        // Exibindo o tempo de execução, comparações e trocas
        System.out.println("Tempo de Execução: " + duration + " nanosegundos");
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
            comparisons++;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                swaps++; // Contando os deslocamentos como trocas
            }

            arr[j + 1] = key;
        }
    }
}
