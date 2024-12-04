package QuickSort;

import java.util.Random;

public class CasoMedio1000 {

    // Variáveis para contar comparações e trocas
    private static int comparacoes = 0;
    private static int trocas = 0;

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
        // Escolhe o pivô de forma aleatória
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low + 1) + low;
        int pivot = arr[pivotIndex];

        // Coloca o pivô no final
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[high];
        arr[high] = temp;
        trocas++; // Contabiliza a troca do pivô

        int i = low - 1; // Índice do menor elemento

        // Loop para reorganizar os elementos em relação ao pivô
        for (int j = low; j < high; j++) {
            comparacoes++; // Contabiliza a comparação
            if (arr[j] <= pivot) {
                i++;
                // Troca arr[i] e arr[j]
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                trocas++; // Contabiliza a troca
            }
        }

        // Coloca o pivô na posição correta
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        trocas++; // Contabiliza a troca do pivô

        return i + 1;
    }

    // Função para medir o tempo de execução em milissegundos
    public static double measureExecutionTime(int[] arr) {
        long startTime = System.nanoTime();  // Tempo de início
        quickSort(arr, 0, arr.length - 1);   // Chama o Quick Sort
        long endTime = System.nanoTime();    // Tempo de fim
        return (endTime - startTime) / 1e6;  // Retorna o tempo em milissegundos
    }

    public static void main(String[] args) {
        // Criando o vetor para o caso médio (vetor com elementos aleatórios)
        int[] medioCase1000 = new int[1000];

        // Preenchendo o vetor com números aleatórios
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            medioCase1000[i] = rand.nextInt(1000); // Valores entre 0 e 999
        }

        // Medindo o tempo de execução para 1000 elementos
        double time1000 = measureExecutionTime(medioCase1000);

        // Exibindo os resultados
        System.out.println("Tempo de Execução: " + time1000 + " ms");
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
    }
}
