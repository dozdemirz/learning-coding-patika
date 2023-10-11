public class Main {
    public static void main(String[] args) {
        double[] numbers = {3.0, 4.0, 5.0};

        double harmonicSum = 0.0;
        int n = numbers.length;


        for (double number : numbers) {
            harmonicSum += 1.0 / number;
        }


        double harmonicMean = n / harmonicSum;

        System.out.println("Dizinin Harmonik Ortalaması: " + harmonicMean);
    }
}
