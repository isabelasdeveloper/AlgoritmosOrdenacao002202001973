package QuickSort;

public class PiorCaso100000 {

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
        // Forçando o pior caso: sempre escolhe o maior elemento como pivô
        int pivot = arr[high];

        int i = (low - 1); // Índice do menor elemento

        // Loop para reorganizar os elementos em relação ao pivô
        for (int j = low; j < high; j++) {
            comparacoes++; // Contabiliza a comparação
            if (arr[j] <= pivot) {
                i++;
                // Troca arr[i] e arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                trocas++; // Contabiliza a troca
            }
        }

        // Coloca o pivô na posição correta
        int temp = arr[i + 1];
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
        return (endTime - startTime) / 1_000_000.0;  // Retorna o tempo em milissegundos
    }

    public static void main(String[] args) {
        // Criando o vetor para o pior caso (vetor já ordenado)
        int[] piorCaso100000 = new int[100000];

        // Preenchendo o vetor com números em ordem crescente
        for (int i = 0; i < 100000; i++) {
            piorCaso100000[i] = i;
        }

        // Medindo o tempo de execução para 100.000 elementos no pior caso
        double time100000 = measureExecutionTime(piorCaso100000);

        // Exibindo os resultados
        System.out.println("Tempo de Execução: " + time100000 + " ms");
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
    }
}
