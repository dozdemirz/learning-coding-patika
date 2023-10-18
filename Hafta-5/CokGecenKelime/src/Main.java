import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("En çok girilen kelimeyi bulmak için bir metin yazınız: ");
        String a = input.nextLine();

        a = a.replaceAll("[\\p{Punct}&&[^']]+", " ");
        String[] kelimeler = a.split("\\s+");

        Map<String, Integer> sayi = new HashMap<>();

        for (String kelime : kelimeler) {
            kelime = kelime.toLowerCase();
            if (!sayi.containsKey(kelime)) {
                sayi.put(kelime, 1);
            } else {
                sayi.put(kelime, sayi.get(kelime) + 1);
            }
        }
xb
        int enCokSayi = 0;
        String enCokGecen = "";
        for (String kelime : sayi.keySet()) {
            if (sayi.get(kelime) > enCokSayi) {
                enCokGecen = kelime;
                enCokSayi = sayi.get(kelime);
            }
        }
        System.out.println("En çok geçen kelime: " + enCokGecen + ". Kelimeden " + enCokSayi + " tane var.");
    }

}