package HeapSort;

import java.util.Random;

public class CasoMedio10000 {
    private static int comparacoes = 0;
    private static int trocas = 0;

    public static void main(String[] args) {
        int n = 10000;
        int[] arr = new int[n];

        // Preencher o array com números aleatórios para simular o caso médio
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100000);  // valores aleatórios entre 0 e 99.999
        }

        long startTime = System.nanoTime();
        heapSort(arr);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime); // em nanossegundos
        System.out.println("Tempo de Execução: " + (duration / 1000000.0) + " ms");
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
    }

    // Função para ordenar usando Heap Sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Construção do heap (max-heap)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Um a um, remove os elementos do heap
        for (int i = n - 1; i > 0; i--) {
            // Mover a raiz atual para o final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            trocas++;

            // Chamar heapify na raiz
            heapify(arr, i, 0);
        }
    }

    // Função para realizar o heapify
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Inicializa o maior como raiz
        int left = 2 * i + 1; // esquerdo = 2*i + 1
        int right = 2 * i + 2; // direito = 2*i + 2

        // Se o filho esquerdo é maior que a raiz
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
            comparacoes++;
        }

        // Se o filho direito é maior que o maior até agora
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
            comparacoes++;
        }

        // Se o maior não é a raiz
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            trocas++;

            // Recursivamente heapify o sub-árvore afetada
            heapify(arr, n, largest);
        }
    }
}
