import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dizinin boyutunu girin: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ". Elemanı girin: ");
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        System.out.print("Sıralama: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }
}
