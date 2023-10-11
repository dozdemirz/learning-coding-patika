import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a sayısını girin: ");
        double a = scanner.nextDouble();

        System.out.print("b sayısını girin: ");
        double b = scanner.nextDouble();

        System.out.print("c sayısını girin: ");
        double c = scanner.nextDouble();

        System.out.println("İşlem sırasını seçin:");
        System.out.println("1. (a+b)*c-b");
        System.out.println("2. a+(b*c)-b");
        System.out.println("3. a+b*(c-b)");
        int secim = scanner.nextInt();

        double sonuc = 0.0;

        switch (secim) {
            case 1:
                sonuc = (a + b) * c - b;
                break;
            case 2:
                sonuc = a + (b * c) - b;
                break;
            case 3:
                sonuc = a + b * (c - b);
                break;
            default:
                System.out.println("Geçersiz seçenek!");
                System.exit(1);
        }

        System.out.println("Sonuç: " + sonuc);
        scanner.close();
    }
}
