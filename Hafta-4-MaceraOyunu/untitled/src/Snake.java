import java.util.Random;

public class Snake extends Monster {


    public Snake() {
        super("Yılan", 4, calculateDmg(), 12, 10);
    }

    public static int calculateDmg() {
        Random r = new Random();
        int max = 6, min = 3;
        return r.nextInt((max - min) + 1) + min;
    }


}
