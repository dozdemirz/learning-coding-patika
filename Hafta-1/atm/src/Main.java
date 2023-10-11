import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int hak = 3;
        int bakiye = 3500;
        String kullanici, sifre;
        System.out.println("Kullanıcı adınızı giriniz:");
        kullanici = input.nextLine();
        System.out.println("Şifrenizi giriniz:");
        sifre = input.nextLine();

        if (kullanici.equals("dilan") && sifre.equals("1234")) {
            System.out.println("Bankanıza giriş yapıldı. Hoşgeldiniz!");
            System.out.println("Yapmak istediğiniz işlemi seçiniz: 1. Para yatırma \n 2. Para çekme \n 3. Bakiye sorgulama \n 4. Çıkış yap");
            int islem = input.nextInt();

            switch (islem) {
                case 1:
                    System.out.println("Yatırmak istediğiniz tutarı giriniz: ");
                    int tutar = input.nextInt();
                    if (tutar < 0) {
                        System.out.println("Hatalı giriş yaptınız.");
                    } else {
                        bakiye += tutar;
                        System.out.println(tutar + " Lira yatırdınız. Yeni bakiyeniz: " + bakiye);
                    }
                    break;
                case 2:
                    System.out.println("Çekmek istediğiniz miktarı giriniz: ");
                    int miktar = input.nextInt();

                    if (miktar < 0) {
                        System.out.println("Hatalı giriş yaptınız.");
                    } else {
                        bakiye -= miktar;
                        System.out.println("Kalan bakiyeniz: " + bakiye);
                    }
                    break;
                case 3:
                    System.out.println("Bakiyeniz: " + bakiye);
                    break;
                case 4:
                    System.out.println("Çıkış yapıldı.");

            }

        } else {
            for (int i = 3; i > 0; i--) {
                System.out.println("Şifreniz yanlış. Bir daha deneyiniz: ");
                sifre = input.nextLine();
                if (sifre.equals("1234")) {
                    System.out.println("Şifre doğru. Hoş geldiniz!");
                    break;
                } else {
                    if (i > 1) {
                        System.out.println("Kalan hakkınız: " + (i - 1));
                    } else {
                        System.out.println("Hakkınız kalmadı");
                    }
                }
            }


        }
    }

}


