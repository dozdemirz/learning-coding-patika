import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        double tutar, kdv = 0.18, kdv2 = 0.08, kdvOran, kdvTutar, kdvliTutar;

        Scanner input = new Scanner(System.in);
        System.out.print("Ücreti giriniz :");
        tutar = input.nextDouble();
        if (tutar < 1000) {
            kdvOran = kdv;
        }

        else {
            kdvOran = kdv2;
        }
        kdvTutar = tutar * kdvOran;
        kdvliTutar = tutar + kdvTutar;

        System.out.println("Kdv'siz tutar : " + tutar);
        System.out.println("Kdv oran : " + kdvOran);
        System.out.println("Kdv tutar : " + kdvTutar);
        System.out.println("Kdv'li tutar : " + kdvliTutar);

    }

}