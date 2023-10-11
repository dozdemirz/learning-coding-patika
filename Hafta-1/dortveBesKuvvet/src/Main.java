import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int sayi;
        System.out.println("Bir sayı giriniz: ");
        sayi = input.nextInt();

        for (int i = 1; i <= sayi; i *= 4) {
            System.out.println("Sayınıza kadar olan 4'ün kuvvetleri : " + i);
        }

        for (int i = 1; i <= sayi; i *= 5) {
            System.out.println("Sayınıza kadar olan 5'in kuvvetleri : " + i);

        }
    }
}