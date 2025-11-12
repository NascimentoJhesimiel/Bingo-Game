import java.util.Scanner;

public class MenuBingo {

    /**
     * Método público para iniciar o jogo de bingo
     * @param scanner Scanner para ler entrada do usuário
     */
    public static void iniciarJogo(Scanner scanner) {
        Cartela bingo = new Cartela();

        // Cria o jogo de bingo (gera uma cartela)
        bingo.createGame(1);

        System.out.println("=== BEM-VINDO AO JOGO DE BINGO ===\n");

        // Exibe a cartela gerada
        System.out.println("Sua cartela de bingo:");
        bingo.mostrarCartela();
        System.out.println();

        // Inicia a navegação do menu
        navegarMenu(scanner, bingo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        iniciarJogo(scanner);
        scanner.close();
    }

    private static void navegarMenu(Scanner scanner, Cartela bingo) {
        int opcao;
        boolean continuar = true;

        while (continuar) {
            exibirMenu();

            try {
                opcao = scanner.nextInt();
                System.out.println();

                switch (opcao) {
                    case 1:
                        sortearNumero(bingo);
                        break;

                    case 2:
                        exibirNumerosSorteados(bingo);
                        break;

                    case 3:
                        exibirQuantidadeSorteados(bingo);
                        break;

                    case 4:
                        verificarNumero(bingo, scanner);
                        break;

                    case 5:
                        System.out.println("Exibindo sua cartela novamente:");
                        bingo.mostrarCartela();
                        System.out.println();
                        break;

                    case 0:
                        System.out.println("Obrigado por jogar! Até logo!");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opção inválida! Por favor, escolha uma opção válida.\n");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida! Por favor, digite um número.\n");
                scanner.nextLine(); // Limpa o buffer
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         MENU DO BINGO                ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 1 → Sortear um novo número           ║");
        System.out.println("║ 2 → Exibir números já sorteados      ║");
        System.out.println("║ 3 → Contar números sorteados         ║");
        System.out.println("║ 4 → Verificar se número foi sorteado ║");
        System.out.println("║ 5 → Exibir minha cartela             ║");
        System.out.println("║ 0 → Sair                             ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Escolha uma opção: ");
    }

    private static void sortearNumero(Cartela bingo) {
        int numeroSorteado = bingo.sortNumber();

        if (numeroSorteado == -1) {
            System.out.println("⚠ Todos os 75 números já foram sorteados!");
            System.out.println("O jogo chegou ao fim!\n");
        } else {
            System.out.println("🎲 Número sorteado: " + numeroSorteado);
            System.out.println("Total de números sorteados até agora: " + bingo.countSortedNumbers());
            System.out.println();
        }
    }

    private static void exibirNumerosSorteados(Cartela bingo) {
        int quantidade = bingo.countSortedNumbers();

        if (quantidade == 0) {
            System.out.println("⚠ Nenhum número foi sorteado ainda.\n");
        } else {
            System.out.println("📋 Lista de números sorteados (" + quantidade + " números):");
            bingo.showSortedNumbers();
            System.out.println();
        }
    }

    private static void exibirQuantidadeSorteados(Cartela bingo) {
        int quantidade = bingo.countSortedNumbers();
        System.out.println("📊 Total de números sorteados: " + quantidade + "/75");
        System.out.println();
    }

    private static void verificarNumero(Cartela bingo, Scanner scanner) {
        System.out.print("Digite o número que deseja verificar (1-75): ");

        try {
            int numero = scanner.nextInt();

            if (numero < 1 || numero > 75) {
                System.out.println("⚠ Número inválido! Digite um número entre 1 e 75.\n");
                return;
            }

            if (bingo.checkIfNumberIsSorted(numero)) {
                System.out.println("✓ O número " + numero + " JÁ foi sorteado!\n");
            } else {
                System.out.println("✗ O número " + numero + " AINDA NÃO foi sorteado.\n");
            }

        } catch (Exception e) {
            System.out.println("⚠ Entrada inválida! Digite um número válido.\n");
            scanner.nextLine(); // Limpa o buffer
        }
    }
}

