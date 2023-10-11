import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please indicate row number of the board: ");            //DEĞERLENDİRME 7
        int rowNumber = input.nextInt();
        System.out.println("Please indicate column number of the board: ");
        int colNumber = input.nextInt();
        input.nextLine();

        MineSweeper game = new MineSweeper(rowNumber, colNumber);
        game.gameStart();

    }
}