import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int hava;

        System.out.println("Hava sıcaklığını giriniz:");
        hava = input.nextInt();


        if (hava < 5) {
            System.out.println("Kayak yapabilirsiniz");
        } else if (hava > 5 && hava < 15) {
            System.out.println("Sinemaya gidebilirsiniz");
        }  else if (hava > 15 && hava < 25) {
            System.out.println("Pikniğe gidebilirsiniz");
        }   else if (hava > 25) {
            System.out.println("Yüzmeye gidebilirsiniz");
        }

        }
    }

