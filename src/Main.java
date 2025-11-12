import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicia o jogo de bingo usando o MenuBingo
        MenuBingo.iniciarJogo(scanner);

        scanner.close();
    }
}