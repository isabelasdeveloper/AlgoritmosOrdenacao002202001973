package ImprovedBubbleSort;

public class MelhorCaso10000 {

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
        // Criando o vetor já ordenado para o melhor caso
        int[] melhorCaso = new int[10000];
        for (int i = 0; i < 10000; i++) {
            melhorCaso[i] = i;
        }

        // Medindo o tempo de execução
        long startTime = System.nanoTime();
        int[] resultados = improvedBubbleSort(melhorCaso);
        long endTime = System.nanoTime();

        // Calculando o tempo em milissegundos
        double tempoExecucao = (endTime - startTime) / 1_000_000.0;

        // Exibindo os resultados
        System.out.println("Tempo de Execução: " + tempoExecucao + " ms");
        System.out.println("Comparações: " + resultados[0]);
        System.out.println("Trocas: " + resultados[1]);
    }
}
