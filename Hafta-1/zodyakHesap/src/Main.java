import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int dogumYili;

        System.out.println("Doğum yılınızı giriniz:");
        dogumYili = input.nextInt();

        String zodyakBurcu = (" ");

        int kalan = dogumYili % 12;

        if (kalan == 0) {
            zodyakBurcu = "Maymun";
        } else if (kalan == 1) {
            zodyakBurcu = "Horoz";
        } else if (kalan == 2) {
            zodyakBurcu = "Köpek";
        } else if (kalan == 3) {
            zodyakBurcu = "Domuz";
        } else if (kalan == 4) {
            zodyakBurcu = "Fare";
        } else if (kalan == 5) {
            zodyakBurcu = "Öküz";
        } else if (kalan == 6) {
            zodyakBurcu = "Kaplan";
        } else if (kalan == 7) {
            zodyakBurcu = "Tavşan";
        } else if (kalan == 8) {
            zodyakBurcu = "Ejderha";
        } else if (kalan == 9) {
            zodyakBurcu = "Yılan";
        } else if (kalan == 10) {
            zodyakBurcu = "At";
        } else if (kalan == 11){
            zodyakBurcu = "Koyun";
        }

        System.out.println("Çin Zodyağı Burcunuz: " + zodyakBurcu);

    }
}


