import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sonuc = 1;
        int a, b;
        System.out.println("Üssü alınacak sayıyı giriniz: ");
        a = input.nextInt();
        System.out.println("Üs olacak sayıyı giriniz: ");
        b = input.nextInt();

        for (int i = 1; i <= b; i++) {
            sonuc *= a;
        }
        System.out.println("Üstlü sayının sonucu :" + sonuc);

    }
}