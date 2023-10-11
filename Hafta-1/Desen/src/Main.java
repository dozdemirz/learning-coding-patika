import java.util.Scanner;


public class Main {
    static void printNumbers(int n) {
        System.out.print(n + " ");

        if (n <= 0) {
            return;
        }

        printNumbers(n - 5);

        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N Sayısı: ");
        int n = scanner.nextInt();
        scanner.close();

        printNumbers(n);
    }


}

