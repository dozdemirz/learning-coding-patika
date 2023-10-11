import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int s1, s2, s3;

        System.out.println("1. sayıyı giriniz: ");
        s1 = input.nextInt();
        System.out.println("2. sayıyı giriniz: ");
        s2 = input.nextInt();
        System.out.println("3. sayıyı giriniz: ");
        s3 = input.nextInt();


        if (s1 < s2 && s1 < s3) {
            if (s2 < s3) {
                System.out.println("s1 < s2 < s3");
            } else {
                System.out.println("s1 < s3 < s2");
            }
        } else if (s2 < s1 && s2 < s3) {
            if (s1 < s3) {
                System.out.println("s2 < s1 < s3");
            } else {
                System.out.println("s2 < s3 < s1");
            }
        } else {
            if (s1 < s2) {
                System.out.println("s3 < s1 < s2");
            } else {
                System.out.println("s3 < s2 < s1");
            }
        }


    }
}""