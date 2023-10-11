import java.util.Scanner;

public class Main {

    static boolean palindrom(int sayi) {
        int tersSayi = 0, sonSayi, sayi1 = sayi;
        while (sayi1 != 0) {
            sonSayi = sayi1 % 10;
            tersSayi = tersSayi * 10 + sonSayi;
            sayi1 /= 10;
        }
        if (tersSayi == sayi) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Palindrom olup olamdığını kontrol etmek istediğiniz bir sayı giriniz: ");
        int sayi = input.nextInt();

        System.out.println(palindrom(sayi));


    }
}