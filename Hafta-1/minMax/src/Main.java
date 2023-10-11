import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int sayi;
        List<Integer> degerler = new ArrayList<>();
        System.out.println("Kaç tane sayı gireceksiniz: ");
        sayi = input.nextInt();


        int i = 1;
        while (i <= sayi) {
            System.out.println(i + ". sayıyı giriniz:");
            int a = input.nextInt();
            degerler.add(a);
            i++;

        }
        int enKucuk = degerler.get(0);
        for (int k = 0; k < degerler.size(); k++) {
            if (degerler.get(k) < enKucuk) {
                enKucuk = degerler.get(k);
            }
        }

        System.out.println("En küçük değer: " + enKucuk);


        int enBuyuk = degerler.get(0);
        for (int j = 0; j < degerler.size(); j++) {
            if (degerler.get(j) > enBuyuk) {
                enBuyuk = degerler.get(j);
            }
        }

        System.out.println("En büyük değer: " + enBuyuk);

    }
}