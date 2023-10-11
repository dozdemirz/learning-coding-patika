public class Main {
    public static void main(String[] args) {

        int[] numbers = {2, 4, 6, 8, 2, 10, 12, 4, 6, 14, 16, 8};

        System.out.println("Tekrar eden çift sayılar:");
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] % 2 == 0) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[j] % 2 == 0 && numbers[i] == numbers[j]) {
                        System.out.println(numbers[i]);
                        break;
                    }
                }
            }
        }
    }
}
