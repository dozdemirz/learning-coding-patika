import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 0;
        int max = 100;
        int targetNumber = random.nextInt(max - min + 1) + min;
        int numberOfGuesses = 0;
        int maxGuesses = 5; // Kullanıcının 5 tahmin hakkı var
        boolean hasGuessedCorrectly = false;

        System.out.println("0 ile 100 arasında bir sayıyı tahmin edin. Toplam 5 tahmin hakkınız var.");

        while (!hasGuessedCorrectly && numberOfGuesses < maxGuesses) {
            System.out.print("Tahmininizi girin: ");
            int userGuess = scanner.nextInt();
            numberOfGuesses++;

            if (userGuess < min || userGuess > max) {
                System.out.println("Lütfen 0 ile 100 arasında bir sayı girin.");
            } else if (userGuess < targetNumber) {
                System.out.println("Daha büyük bir sayı deneyin.");
            } else if (userGuess > targetNumber) {
                System.out.println("Daha küçük bir sayı deneyin.");
            } else {
                System.out.println("Tebrikler! " + targetNumber + " sayısını " + numberOfGuesses + " tahminde buldunuz.");
                hasGuessedCorrectly = true;
            }

            if (!hasGuessedCorrectly && numberOfGuesses < maxGuesses) {
                System.out.println("Kalan tahmin hakkınız: " + (maxGuesses - numberOfGuesses));
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Tahmin hakkınız bitti. Doğru cevap " + targetNumber + " idi.");
        }

        scanner.close();
    }
}
