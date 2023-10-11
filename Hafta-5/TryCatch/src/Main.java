import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Scanner input = new Scanner(System.in);
        System.out.println("Çağırmak istediğiniz indeksi yazınız:");
        int ask = input.nextInt();

        try {
            System.out.println(arr[ask - 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Geçersiz indeks. Lütfen 0 ile" + arr.length + " arasında bir sayı giriniz.");
        }
    }
}

