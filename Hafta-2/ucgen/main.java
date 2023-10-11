import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        double a, b, c, cevre, alan, u, alan2;

        Scanner input = new Scanner(System.in);
        System.out.println("1. Kenarı giriniz :");
        a = input.nextDouble();
        System.out.println("2. Kenarı giriniz :");
        b = input.nextDouble();

        c = Math.sqrt((a * a) + (b * b));
        System.out.println("Üçgenin hipotenüsü :" + c);

        u = (a + b + c) / 2;
        cevre = 2 * u;
        System.out.println("Üçgenin çevresi :" + cevre);

        alan2 = u * (u - a) * (u - b) * (u - c);
        alan = Math.sqrt(alan2);
        System.out.println("Üçgenin alanı :" + alan);
    }
}