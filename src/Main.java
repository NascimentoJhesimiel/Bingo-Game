import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuBingo.iniciarJogo(scanner);
        scanner.close();
    }
}