import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan bir tam sayı girişi
        System.out.print("Bir tam sayı giriniz: ");
        int tamSayi = scanner.nextInt();

        // Kullanıcıdan bir ondalıklı sayı girişi
        System.out.print("Bir ondalıklı sayı giriniz: ");
        double ondalikliSayi = scanner.nextDouble();

        // Tam sayıyı ondalıklı sayıya
        double tamSayiOndalikli = (double) tamSayi;

        // Ondalıklı sayıyı tam sayıya
        int ondalikliSayiTam = (int) ondalikliSayi;

        // Sonuçlar
        System.out.println("Tam Sayıdan Ondalıklı Sayıya Dönüşüm: " + tamSayiOndalikli);
        System.out.println("Ondalıklı Sayıdan Tam Sayıya Dönüşüm: " + ondalikliSayiTam);
    }
}
