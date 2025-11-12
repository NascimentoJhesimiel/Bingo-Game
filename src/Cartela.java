import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cartela implements IBingo {

  private int[][] cartela;
  private List<Integer> numerosSorteados;
  private Random random;

  public Cartela() {
    this.numerosSorteados = new ArrayList<>();
    this.random = new Random();
  }

  @Override
  public Cartela createGame(int quantity) {
    // O parâmetro 'quantity' não é usado nesta implementação,
    // pois o método cria uma única cartela.
    this.cartela = new int[5][5];
    List<Integer> numerosDisponiveis = new ArrayList<>();

    // Preenche cada coluna com números aleatórios e únicos
    for (int coluna = 0; coluna < 5; coluna++) {
      numerosDisponiveis.clear();
      int inicioIntervalo = coluna * 15 + 1;
      int fimIntervalo = inicioIntervalo + 14;

      for (int i = inicioIntervalo; i <= fimIntervalo; i++) {
        numerosDisponiveis.add(i);
      }

      Collections.shuffle(numerosDisponiveis);

      for (int linha = 0; linha < 5; linha++) {
        // O espaço central (2,2) é livre
        if (linha == 2 && coluna == 2) {
          cartela[linha][coluna] = 0;
        } else {
          cartela[linha][coluna] = numerosDisponiveis.remove(0);
        }
      }
    }
    return this;
  }

  @Override
  public int sortNumber() {
    if (numerosSorteados.size() >= 75) {
      return -1; // Todos os números já foram sorteados
    }

    int numeroSorteado;
    do {
      numeroSorteado = random.nextInt(75) + 1;
    } while (numerosSorteados.contains(numeroSorteado));

    numerosSorteados.add(numeroSorteado);
    return numeroSorteado;
  }

  @Override
  public void showSortedNumbers() {
    System.out.println("Números sorteados:");
    for (Integer numero : numerosSorteados) {
      System.out.print(numero + " ");
    }
    System.out.println();
  }

  @Override
  public int countSortedNumbers() {
    return numerosSorteados.size();
  }

  @Override
  public boolean checkIfNumberIsSorted(int number) {
    return numerosSorteados.contains(number);
  }

  // Método adicional para visualizar a cartela gerada
  public void mostrarCartela() {
    System.out.println("B\tI\tN\tG\tO");
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.print(cartela[i][j] + "\t");
      }
      System.out.println();
    }
  }
}
