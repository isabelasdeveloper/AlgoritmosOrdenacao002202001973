package QuickSort;

// MelhorCaso100000

import java.util.Random;

public class MelhorCaso100000 {

    // Contadores para comparações e trocas
    static int comparacoes = 0;
    static int trocas = 0;

    // Função para realizar o Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Particiona o vetor e retorna a posição do pivô
            int pi = partition(arr, low, high);

            // Ordena as sublistas
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Função para particionar o vetor
    public static int partition(int[] arr, int low, int high) {
        // Escolhe o pivô de forma aleatória para evitar o pior caso
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low + 1) + low;
        int pivot = arr[pivotIndex];

        // Coloca o pivô no final
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[high];
        arr[high] = temp;

        int i = low - 1; // Índice do menor elemento

        // Loop para reorganizar os elementos em relação ao pivô
        for (int j = low; j < high; j++) {
            comparacoes++;  // Contabiliza a comparação
            if (arr[j] <= pivot) {
                i++;
                // Troca arr[i] e arr[j]
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                trocas++;  // Contabiliza a troca
            }
        }

        // Coloca o pivô na posição correta
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        trocas++;  // Contabiliza a troca

        return i + 1;
    }

    // Função para medir o tempo de execução
    public static long measureExecutionTime(int[] arr) {
        long startTime = System.nanoTime();  // Tempo de início
        quickSort(arr, 0, arr.length - 1);   // Chama o Quick Sort
        long endTime = System.nanoTime();    // Tempo de fim
        return (endTime - startTime) / 1000000; // Retorna o tempo em milissegundos
    }

    public static void main(String[] args) {
        // Criando o vetor para o melhor caso (vetor já ordenado)
        int[] bestCase100000 = new int[100000];

        // Preenchendo o vetor com números em ordem crescente (Melhor Caso)
        for (int i = 0; i < 100000; i++) {
            bestCase100000[i] = i;
        }

        // Medindo o tempo de execução para 100.000 elementos
        long time100000 = measureExecutionTime(bestCase100000);

        // Exibindo o tempo de execução, comparações e trocas
        System.out.println("Tempo de execução: " + time100000 + " ms");
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
    }
}
