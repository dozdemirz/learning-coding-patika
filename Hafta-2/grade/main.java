import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int mat, fizik, kimya, turkce, tarih, muzik;
        Scanner inp = new Scanner(System.in);

        System.out.println("Matematik Notunuz: ");
        mat = inp.nextInt();

        System.out.println("Fizik Notunuz: ");
        fizik = inp.nextInt();

        System.out.println("Türkçe Notunuz: ");
        turkce = inp.nextInt();

        System.out.println("Kimya Notunuz: ");
        kimya = inp.nextInt();

        System.out.println("Tarih Notunuz: ");
        tarih = inp.nextInt();

        System.out.println("Müzik Notunuz: ");
        muzik = inp.nextInt();

        double sonuc = ((mat + fizik + kimya + turkce + tarih + muzik)/6);
        boolean kosul = sonuc > 60;
        String str = (kosul) ? "Geçtiniz" : "Kaldınız";

        System.out.println(sonuc + " " + str);
    }}