public class Main {
    public static void main(String[] args) {

        int[][] matris = {
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println("Matris:");
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[0].length; j++) {
                System.out.print(matris[i][j] + "\t");
            }
            System.out.println();
        }

                                                                                                                                      
        int[][] transpoz = new int[matris[0].length][matris.length];


        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[0].length; j++) {
                transpoz[j][i] = matris[i][j];
            }
        }

        System.out.println("Transpoze Matris:");
        for (int i = 0; i < transpoz.length; i++) {
            for (int j = 0; j < transpoz[0].length; j++) {
                System.out.print(transpoz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

