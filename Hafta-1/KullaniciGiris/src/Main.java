import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dogrusifre = "12345";
        String yenisifre, secenek, girilensifre;

        System.out.print("Lütfen şifrenizi giriniz: ");
        girilensifre = scanner.nextLine();

        if (girilensifre.equals(dogrusifre)) {
            System.out.println("Giriş başarılı.");
        } else {
            System.out.println("Hatalı şifre girişi. Şifrenizi sıfırlamak ister misiniz? (Evet/Hayır): ");
            secenek = scanner.nextLine();

            if (secenek.equalsIgnoreCase("Evet")) {
                System.out.print("Yeni şifrenizi giriniz: ");
                yenisifre = scanner.nextLine();

                if (yenisifre.equals(dogrusifre)) {
                    System.out.println("Yeni şifre eski şifre ile aynı olamaz. Şifre sıfırlanmadı.");

                } else {
                    System.out.println("Şifre sıfırlandı ve güncellendi.");
                }
            }
        }
    }
}