import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir sayı girin: ");
        int target = scanner.nextInt();

        Arrays.sort(numbers);

        int closestSmaller = Integer.MIN_VALUE;
        int closestGreater = Integer.MAX_VALUE;

        for (int number : numbers) {
            if (number < target && number > closestSmaller) {
                closestSmaller = number;
            }
            if (number > target && number < closestGreater) {
                closestGreater = number;
            }
        }

        if (closestSmaller != Integer.MIN_VALUE) {
            System.out.println("Girilen sayıdan küçük en yakın sayı: " + closestSmaller);
        } else {
            System.out.println("Girilen sayıdan küçük bir sayı bulunamadı.");
        }

        if (closestGreater != Integer.MAX_VALUE) {
            System.out.println("Girilen sayıdan büyük en yakın sayı: " + closestGreater);
        } else {
            System.out.println("Girilen sayıdan büyük bir sayı bulunamadı.");
        }
    }
}
