import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sayi1 = 0, sayi2 = 1, toplam;
        int eleman;
        List<Integer> liste = new ArrayList<>();
        System.out.println("Fibonacci serisinin eleman sayısını giriniz: ");
        eleman = input.nextInt();

        for (int i = 0; i <= eleman; i++) {
            toplam = sayi1 + sayi2;
            liste.add(sayi1);
            sayi1 = sayi2;
            sayi2 = toplam;
        }
        System.out.println(eleman + " elemanlı Fibonacci serisi: " + liste);
    }
}