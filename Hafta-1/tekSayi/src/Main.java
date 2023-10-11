import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int sayi = 0, toplam = 0;


        while (sayi % 2 == 0) {
            System.out.println("Sayı giriniz:");
            sayi = input.nextInt();
            if (sayi % 4 == 0) {
                toplam += sayi;
            }
        }
        System.out.println("Çift ve 4'ün katları olan sayıların toplamı: " + toplam);

    }
}