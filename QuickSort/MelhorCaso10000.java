package QuickSort;

public class MelhorCaso10000 {

    // Contadores para comparações e trocas
    static int comparacoes = 0;
    static int trocas = 0;

    // Função para realizar o Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Particiona o vetor
            int pi = partition(arr, low, high);

            // Ordena as sublistas
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Função para particionar o vetor
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Pivô é o último elemento
        int i = (low - 1);  // Índice do menor elemento

        for (int j = low; j < high; j++) {
            comparacoes++;  // Contabiliza a comparação
            // Se o elemento atual for menor ou igual ao pivô
            if (arr[j] <= pivot) {
                i++;
                // Troca arr[i] e arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                trocas++;  // Contabiliza a troca
            }
        }

        // Troca arr[i+1] e arr[high] (pivô)
        int temp = arr[i + 1];
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
        int[] bestCase10000 = new int[10000];

        // Preenchendo o vetor com números em ordem crescente
        for (int i = 0; i < 10000; i++) {
            bestCase10000[i] = i;
        }

        // Medindo o tempo de execução para 10.000 elementos
        long time10000 = measureExecutionTime(bestCase10000);

        // Exibindo o tempo de execução, comparações e trocas
        System.out.println("Tempo de execução: " + time10000 + " ms");
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
    }
}
