import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir kelime girin: ");
        String kelime = scanner.nextLine().toLowerCase();

        if (isPalindrome(kelime)) {
            System.out.println(kelime + " bir palindromik kelimedir.");
        } else {
            System.out.println(kelime + " bir palindromik kelime değildir.");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String kelime) {
        int uzunluk = kelime.length();
        for (int i = 0; i < uzunluk / 2; i++) {
            if (kelime.charAt(i) != kelime.charAt(uzunluk - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
