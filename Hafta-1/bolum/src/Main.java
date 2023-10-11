import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sayi, toplam = 0, sayiSayisi = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Bir sayı giriniz: ");
        sayi = input.nextInt();

        for (int i = 0; i <= sayi; i++) {
            if (i % 3 == 0 && i % 4 == 0) {
                toplam += i;
                sayiSayisi++;
            }
        }

        if (sayiSayisi > 0) {
            double ortalama = (double) toplam / sayiSayisi;
            System.out.println("3 ve 4'e tam bölünen sayıların ortalaması: " + ortalama);
        } else {
            System.out.println("3 ve 4'e tam bölünen sayı bulunamadı.");
        }
    }
}
