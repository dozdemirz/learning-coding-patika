import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {15, 203, 203, 15, 15, 20, 5, 203};

        int[] frequencies = new int[array.length];

        Arrays.fill(frequencies, -1);

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int frequency = 1;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == num) {
                    frequency++;
                    frequencies[j] = 0;
                }
            }

            if (frequencies[i] != 0) {
                frequencies[i] = frequency;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (frequencies[i] != 0) {
                System.out.println(array[i] + " sayısı " + frequencies[i] + " kere tekrar edildi.");
            }
        }
    }
}
