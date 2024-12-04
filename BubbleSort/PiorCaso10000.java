package BubbleSort;

public class PiorCaso10000 {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparacoes++; // Incrementa a cada comparação
                if (arr[j] > arr[j + 1]) {
                    // Troca de elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocas++; // Incrementa a cada troca
                    swapped = true;
                }
            }
            // Se nenhuma troca foi feita, o vetor já está ordenado
            if (!swapped) break;
        }

        // Exibir os resultados
        System.out.printf("Comparações: %d%n", comparacoes);
        System.out.printf("Trocas: %d%n", trocas);
    }

    public static void main(String[] args) {
        // Vetor de 10.000 elementos em ordem inversa (pior caso)
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 10000 - i; // Vetor ordenado de forma inversa
        }

        // Medir o tempo de execução
        long startTime = System.nanoTime();
        bubbleSort(arr);
        long endTime = System.nanoTime();

        // Tempo de execução em milissegundos
        System.out.printf("Tempo de execução: %.5f ms%n", (endTime - startTime) / 1e6);
    }
}


