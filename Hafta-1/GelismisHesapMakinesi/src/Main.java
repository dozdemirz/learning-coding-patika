import java.util.Scanner;

public class Main {
    static void toplama() {
        Scanner input = new Scanner(System.in);
        int sayiSayisi, sayi, sonuc = 0;
        System.out.println("Kaç sayı gireceksiniz: ");
        sayiSayisi = input.nextInt();


        for (int i = 1; i <= sayiSayisi; i++) {
            System.out.println(i + ". sayıyı giriniz: ");
            sayi = input.nextInt();
            sonuc += sayi;
        }
        System.out.println("Sonuç : " + sonuc);

    }

    static void cikarma() {
        Scanner input = new Scanner(System.in);
        int sayiSayisi, sayi, sonuc, sayi1;
        System.out.println("Kaç sayı gireceksiniz: ");
        sayiSayisi = input.nextInt();

        System.out.println("Çıkarılacak sayıyı giriniz:");
        sayi1 = input.nextInt();
        sonuc = sayi1;
        for (int i = 1; i <= (sayiSayisi - 1); i++) {
            System.out.println(i + ". çıkarılan sayıyı giriniz: ");
            sayi = input.nextInt();
            sonuc -= sayi;

        }
        System.out.println("Sonuç : " + sonuc);
    }

    static void carpma() {
        Scanner input = new Scanner(System.in);
        int sayiSayisi, sonuc = 1, sayi;
        System.out.println("Kaç sayı gireceksiniz?");
        sayiSayisi = input.nextInt();

        for (int i = 1; i <= sayiSayisi; i++) {
            System.out.println(i + ". sayıyı giriniz: ");
            sayi = input.nextInt();

            sonuc *= sayi;
        }
        System.out.println("Sonuç : " + sonuc);
    }

    static void bolme() {
        Scanner input = new Scanner(System.in);
        int sayiSayisi;
        double sonuc = 1.0, sayi;
        System.out.println("Kaç sayı gireceksiniz?");
        sayiSayisi = input.nextInt();

        for (int i = 1; i <= sayiSayisi; i++) {
            System.out.println(i + ". sayıyı giriniz: ");
            sayi = input.nextInt();
            if (sayi == 0) {
                System.out.println("Böleni 0 giremezsiniz.");
            } else if (i == 1) {
                sonuc = sayi;
            } else {
                sonuc /= sayi;
            }
        }
        System.out.println("Sonuç : " + sonuc);
    }

    static void uslu() {
        Scanner input = new Scanner(System.in);
        int sayi, us, sonuc = 1;
        System.out.println("Üstü alınacak sayıyı giriniz ");
        sayi = input.nextInt();
        System.out.println("Üst olacak sayıyı giriniz ");
        us = input.nextInt();


        for (int i = 1; i <= us; i++) {
            sonuc *= sayi;
        }
        System.out.println("Sonuç : " + sonuc);
    }

    static void faktoriyel() {
        Scanner input = new Scanner(System.in);
        int sayi, sonuc = 1;
        System.out.println("Faktoriyeli alınacak sayıyı giriniz ");
        sayi = input.nextInt();

        for (int i = 1; i <= sayi; i++) {
            sonuc *= i;
        }
        System.out.println("Sonuç : " + sonuc);
    }

    static void mod() {
        Scanner input = new Scanner(System.in);
        int sayi, sonuc, mod;
        System.out.println("Modu alınacak sayıyı giriniz ");
        sayi = input.nextInt();
        System.out.println("Kaçıncı modunu alacağınızı giriniz");
        mod = input.nextInt();

        sonuc = sayi % mod;

        System.out.println("Sonuç : " + sonuc);
    }

    static void dikdortgenAlan() {
        Scanner input = new Scanner(System.in);
        int en, boy, alan, cevre;
        System.out.println("Dikdörtgenin enini giriniz :");
        en = input.nextInt();
        System.out.println("Dikdörtgenin boyunu giriniz :");
        boy = input.nextInt();

        alan = en * boy;
        cevre = (en * 2) + (boy * 2);


        System.out.println("Dikdörtgenin alanı: " + alan + "\nDikdörtgenin çevresi: " + cevre);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int secenek;
        String menu = "1- Toplama İşlemi\n"
                + "2- Çıkarma İşlemi\n"
                + "3- Çarpma İşlemi\n"
                + "4- Bölme işlemi\n"
                + "5- Üslü Sayı Hesaplama\n"
                + "6- Faktoriyel Hesaplama\n"
                + "7- Mod Alma\n"
                + "8- Dikdörtgen Alan ve Çevre Hesabı\n"
                + "0- Çıkış Yap";


        System.out.println(menu);
        System.out.println("Lütfen bir işlem seçiniz: ");
        secenek = input.nextInt();

        switch (secenek) {
            case 1 -> toplama();
            case 2 -> cikarma();
            case 3 -> carpma();
            case 4 -> bolme();
            case 5 -> uslu();
            case 6 -> faktoriyel();
            case 7 -> mod();
            case 8 -> dikdortgenAlan();
            case 0 -> System.out.println("Çıkış yapıldı.");
            default -> System.out.println("Yanlış bir değer girdiniz, tekrar deneyiniz.");
        }


    }
}

