import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int yas;
        double kmfiyat = 0.10, km, fiyat, yasindirimi, tipİndirimi, fiyat1;
        int yolculuktipi;
        fiyat = 0;

        System.out.println("Gidilecek mesafeyi yazınız (km cinsinden)");
        km = input.nextDouble();

        if (km > 0) {
            km = km;
        } else {
            System.out.println("Hatalı giriş yaptınız.");
            System.exit(0);
        }

        System.out.println("Yaşınızı giriniz:");
        yas = input.nextInt();

        if (yas > 0) {
            yas = yas;
        } else {
            System.out.println("Hatalı giriş yaptınız.");
            System.exit(0);
        }

        System.out.println("Yolculuk tipinizi seçiniz 1/2?  \n 1: Tek yön \n 2: Gidiş dönüş");
        yolculuktipi = input.nextInt();

        if (yolculuktipi == 1 || yolculuktipi == 2) {
            yolculuktipi = yolculuktipi;
        } else {
            System.out.println("Hatalı giriş yaptınız.");
            System.exit(0);
        }

        if (yas > 0 && yas < 12) {
            yasindirimi = (km * kmfiyat) * 0.5;
            System.out.println("Yaş indiriminiz:" + yasindirimi);
            fiyat = (km * kmfiyat) - (yasindirimi);
            System.out.println("Yaş indirimli tutarınız:" + fiyat);
        } else if (yas >= 12 && yas <= 24) {
            yasindirimi = (km * kmfiyat) * 0.1;
            System.out.println("Yaş indiriminiz:" + yasindirimi);
            fiyat = (km * kmfiyat) - (yasindirimi);
            System.out.println("Yaş indirimli tutarınız:" + fiyat);
        } else if (yas > 24 && yas <= 65) {
            fiyat = km * kmfiyat;
            System.out.println("Yaş indiriminiz bulunmamaktadır.");
        } else if (yas > 65) {
            yasindirimi = (km * kmfiyat) * 0.3;
            System.out.println("Yaş indiriminiz:" + yasindirimi);
            fiyat = (km * kmfiyat) - (yasindirimi);
            System.out.println("Yaş indirimli tutarınız:" + fiyat);
        }


        switch (yolculuktipi) {
            case 1:
                System.out.println("Uçuş tipine göre indiriminiz bulunmamaktadır");
                System.out.println("Toplam fiyatınız :" + fiyat);
                break;
            case 2:
                tipİndirimi = (fiyat) * 0.2;
                System.out.println("Gidiş dönüş bilet indiriminiz: " + tipİndirimi);
                fiyat1 = (fiyat - tipİndirimi) * 2;
                System.out.println("2 Bilet toplam fiyatınız: " + fiyat1);
                break;
            default:
                System.out.println("Hatalı giriş yaptınız.");

        }

    }

}
