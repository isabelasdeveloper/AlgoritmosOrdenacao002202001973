package ImprovedBubbleSort;

import java.util.Random;

public class CasoMedio100000 {

    // Função para realizar o Improved Bubble Sort
    public static int[] improvedBubbleSort(int[] arr) {
        int n = arr.length;
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean trocado = false;

            for (int j = 0; j < n - i - 1; j++) {
                comparacoes++;
                if (arr[j] > arr[j + 1]) {
                    // Troca os elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocas++;
                    trocado = true;
                }
            }

            // Se nenhuma troca foi feita, a lista está ordenada
            if (!trocado) break;
        }

        return new int[]{comparacoes, trocas};
    }

    public static void main(String[] args) {
        // Criando o vetor com elementos aleatórios
        int[] casoMedio = new int[100000];
        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            casoMedio[i] = random.nextInt(100000); // Valores aleatórios entre 0 e 99999
        }

        // Medindo o tempo de execução
        long startTime = System.nanoTime();
        int[] resultados = improvedBubbleSort(casoMedio);
        long endTime = System.nanoTime();

        // Calculando o tempo em milissegundos
        double tempoExecucao = (endTime - startTime) / 1_000_000.0;

        // Exibindo os resultados
        System.out.println("Tempo de Execução: " + tempoExecucao + " ms");
        System.out.println("Comparações: " + resultados[0]);
        System.out.println("Trocas: " + resultados[1]);
    }
}
