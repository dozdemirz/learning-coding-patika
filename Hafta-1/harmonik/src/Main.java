import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Bir sayı giriniz: ");
        double sayi = input.nextInt();
        double toplam = 0;

        for (double i = 1; i <= sayi; i++) {
            toplam += (1 / i);
        }
        System.out.println("Harmonik serisinin sonucu:" + toplam);
    }
}