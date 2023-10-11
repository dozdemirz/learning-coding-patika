import java.util.Scanner;

public class Main {
    static boolean asal(int sayi, int bolen) {
        if (bolen < 2) {
            return true;
        }
        if (sayi % bolen == 0) {
            return false;
        }
        return asal(sayi, bolen - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sayı Giriniz: ");
        int sayi = scanner.nextInt();

        if (sayi < 2) {
            System.out.println(sayi + " sayısı asal değildir !");
        } else {
            if (asal(sayi, (int) Math.sqrt(sayi))) {
                System.out.println(sayi + " sayısı asaldır !");
            } else {
                System.out.println(sayi + " sayısı asal değildir !");
            }
        }

    }


}
