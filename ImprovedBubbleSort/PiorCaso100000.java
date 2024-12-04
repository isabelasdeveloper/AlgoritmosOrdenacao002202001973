package ImprovedBubbleSort;

public class PiorCaso100000 {
    public static void main(String[] args) {
        // Criando um array de 100.000 elementos no pior caso (array ordenado reversamente)
        int n = 100000;
        int[] array = new int[n];

        // Preenche o array de forma decrescente (pior caso para o algoritmo)
        for (int i = 0; i < n; i++) {
            array[i] = n - i;
        }

        long startTime = System.nanoTime();

        // Chamada do Improved Bubble Sort
        improvedBubbleSort(array);

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

    public static void improvedBubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Implementação do Improved Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    // Troca os elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }

            // Se não houve troca, o array já está ordenado
            if (!swapped) {
                break;
            }
        }
    }
}
