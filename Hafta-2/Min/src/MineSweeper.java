import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MineSweeper {
    int rowNumber, colNumber, size, mineCount, counter;
    boolean game = true;
    boolean isWin = false;
    boolean check = true;
    int openedPlace = 0;
    String[][] map;
    String[][] gameBoard;
    Scanner input = new Scanner(System.in);
    ArrayList<String> selectedCells = new ArrayList<>();

    // Kurucu metot
    MineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.map = new String[rowNumber][colNumber];
        this.gameBoard = new String[rowNumber][colNumber];
        this.size = rowNumber * colNumber;
        this.mineCount = this.size / 4;

        gameMap(gameBoard); //Yaptığım gameMap metodu sayesinde gameBoard ve map içerisine -'leri attım
        gameMap(map);
        placingMines(map); //Burada ise sadece map içerisine mayınları yerleştirdim ki oynayan kişi bunları gameBoard içerisinde göremesin
        printMap(map);  //Bu sizin mayınlarla beraber olan oyunu görebilmeniz ve anlayabilmeniz için eklendi
        System.out.println("=========Game start!=========");
        printMap(gameBoard); //Burada ise oynayan kişiye mayınların gözükmediği versiyonu gösteriliyor
    }

    //Oyunu başlatmak için olan metot
    public void gameStart() {
        while (game) {
            coordinatesCheck();
        }
    }

    public void placingMines(String[][] mines) {
        int mineCount = (this.rowNumber * this.colNumber) / 4;
        Random r = new Random();
        while (mineCount > 0) {
            int randomRow = r.nextInt(rowNumber); //Burada 2 tane rastgele sayı almamız sayesinde her oyun farklı ama istenen sayıda mayın yerleştirebiliyoruz
            int randomCol = r.nextInt(colNumber);

            if (!(mines[randomRow][randomCol].equals(" * "))) { //Mayın atanacak yere daha önce mayın atanmamışsa atama yapıyoruz
                mines[randomRow][randomCol] = " * ";
                mineCount--;
            }
        }
    }

    //Oyun tahtasını oluşturduğumuz metot.
    public void gameMap(String[][] gMap) {
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                gMap[i][j] = " - ";
            }
        }
    }

    //Kullanıcıdan oynamak istediği koordinatları alan ve buna göre oyunu yönlendiren metot
    public void coordinatesCheck() {
        int row = 0, col = 0, surroundingMine = 0;
        counter++;
        check = true;
        while (check) {
            System.out.println("Enter row number you want to play (Between 1-" + rowNumber + ") : ");
            row = input.nextInt() - 1;
            System.out.println("Enter column number you want to play (Between 1-" + colNumber + ") : ");
            col = input.nextInt() - 1;
            input.nextLine();

            String selectedCell = row + "-" + col;
            if (selectedCells.contains(selectedCell)) {  //Oyunu oynarken aynı koordinatları seçtiğimde henüz açılmamış koordinat varken bile kazandığımı düşünüyordu. O yüzden aynı koordinatların seçilmesini önceden seçilenleri bir array'e atarak engelledim
                System.out.println("You already selected this cell. Please try again.");
            } else if (row < 0 || row >= rowNumber || col < 0 || col >= colNumber) {
                System.out.println("Wrong coordinates. Please try again."); //Eğer girilen koordinatlar oyunun oynandığı board'ın büyüklüğünden fazlaysa veya olması gerekenden küçükse hata veriyoruz
            } else {
                check = false;
                selectedCells.add(selectedCell);
            }
        }
        if ((map[row][col]).equals(" * ")) {
            System.out.println("Game Over. :("); //Eğer kullanıcı mayına basarsa oyunu direkt bitiren bölge
            printMap(map);
            game = false;
        } else {
            for (int r = -1; r < 2; r++) {
                for (int c = -1; c < 2; c++) {
                    if ((row + r) >= 0 && (row + r) < rowNumber && (col + c) >= 0 && (col + c) < colNumber) {
                        if ((map[row + r][col + c]).equals(" * ")) {
                            surroundingMine++;
                        }
                    }
                }
            }
            gameBoard[row][col] = " " + surroundingMine + " ";
            openedPlace++;                          //Mayına basmayıp etraftaki mayınların sayısını yazdırdığımız her döngüde openedPlace'i 1 arttırıyoruz
            if (openedPlace == size - mineCount) {  //Bu sayede açılabilecek tüm mayınsız alanlar açıldığında kazandığımızı sorgulayabileceğiz
                isWin = true;
            }
            if (isWin) {
                game = false;
                System.out.println("You won!!!!");
                printMap(map);
            } else {
                printMap(gameBoard);
            }
        }
    }

    //Oyun tahtasını ekrana yazdırdığımız metot
    public void printMap(String[][] print) {
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                System.out.print(print[i][j] + " ");
            }
            System.out.println();
        }
    }
}
