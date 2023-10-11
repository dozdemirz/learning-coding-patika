import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n, r;
        System.out.println("Bir sayı giriniz: ");
        n = input.nextInt();
        System.out.println("Bir sayı giriniz: ");
        r = input.nextInt();
        int toplamN = 1;
        int toplamR = 1;
        int toplamNR = 1;

        for (int i = 1; i <= n; i++) {
            toplamN *= i;

        }

        for (int i = 1; i <= r; i++) {
            toplamR *= i;
        }

        for (int i = 1; i <= n - r; i++) {
            toplamNR *= i;
        }

        int sonuc = toplamN / (toplamR * toplamNR);
        System.out.println("Kombinasyonun sonucu: " + sonuc);
    }
}