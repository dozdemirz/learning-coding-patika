import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int basamak;
        System.out.println("Basamak sayısını giriniz:");
        basamak = input.nextInt();

        for (int i = 1; i <= basamak; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = i; k < basamak; k++) {
                System.out.print("*");
            }
            for (int l = i; l <= basamak; l++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
