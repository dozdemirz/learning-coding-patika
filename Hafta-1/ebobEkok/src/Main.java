import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int s1, s2;
        System.out.println("Birinci sayıyı yazınız: ");
        s1 = input.nextInt();
        System.out.println("İkinci sayıyı yazınız: ");
        s2 = input.nextInt();
        List<Integer> degerler = new ArrayList<>();
        List<Integer> degerler2 = new ArrayList<>();

        int i = 1;
        while (i <= s1) {
            if (s1 % i == 0) {
                degerler.add(i);

            }
            i++;
        }


        int k = 1;
        while (k <= s2) {
            if (s2 % k == 0) {
                degerler2.add(k);

            }
            k++;
        }


        List<Integer> ortak = new ArrayList<>();
        for (Integer deger : degerler) {
            if (degerler2.contains(deger)) {
                ortak.add(deger);

            }
        }
        int a = ortak.size();
        int ebob = ortak.get(a - 1);
        System.out.println("İki sayının EBOB'u: " + ebob);

        int ekok = (s1 * s2) / ebob;
        System.out.println("İki sayının EKOK'u: " + ekok);
    }
}