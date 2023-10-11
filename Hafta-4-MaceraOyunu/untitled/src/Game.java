import java.util.Scanner;

public class Game {
    public void gameStart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Macera oyunu başlıyor!");
        System.out.println("Lütfen bir isim giriniz: ");
        String playerName = input.nextLine();
        System.out.println("Sayın " + playerName + " macera oyununa hoş geldin!");
        Player player = new Player(playerName);
        System.out.println("Lütfen bir karakter seçiniz: ");
        player.selectChar();
        player.selectLoc();


    }
}
