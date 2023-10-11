import java.util.Scanner;


public class Main {

    static int us(int a, int b) {

        if (b == 0) {
            return 1;
        } else {
            return a * us(a, b - 1);
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b;
        while (true) {
            System.out.println("Taban değerini giriniz: ");
            a = input.nextInt();
            System.out.println("Üs değerini giriniz: ");
            b = input.nextInt();

            int sonuc = us(a, b);
            System.out.println(sonuc);
        }
    }
}
