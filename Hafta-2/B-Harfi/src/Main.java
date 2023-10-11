public class Main {
    public static void main(String[] args) {
        int n = 7;

        char[][] letterB = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || (i == 0 && j != n - 1) || (i == n - 1 && j != n - 1) || (j == n - 1 && i != 0 && i != n / 2 && i != n - 1) || (i == n / 2 && j != n - 1 && j != 0)) {
                    letterB[i][j] = '*';
                } else {
                    letterB[i][j] = ' ';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(letterB[i][j] + " ");
            }
            System.out.println();
        }
    }
}
