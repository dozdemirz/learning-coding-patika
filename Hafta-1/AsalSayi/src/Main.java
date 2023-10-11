
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        for (int i = 2; i <= 100; i++) {
            int kosul = 0;
            for (int k = 2; k < i; k++) {
                if (i % k == 0) {
                    kosul = 1;

                }
            }
            if (kosul == 0) {
                System.out.print(i + " ");
            }
        }
    }
}

