import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Fikstur {
    public static List<String> fiksturOlustur(List<String> teams) {
        int teamCount = teams.size();


        if (teamCount % 2 != 0) {
            teams.add("Bay");
            teamCount++;
        }
        int secondHalfCount = teamCount;

        int rounds = teamCount - 1;

        List<String> firstHalfFixture = new ArrayList<>();

        for (int round = 0; round < rounds; round++) {


            System.out.println();
            System.out.println("Hafta " + (round + 1) + " Maçları (İlk Yarı):");
            System.out.println();
            for (int i = 0; i < teamCount / 2; i++) {
                String homeTeam = teams.get(i);
                String awayTeam = teams.get(teamCount - 1 - i);
                firstHalfFixture.add(homeTeam + " vs " + awayTeam);
                System.out.println(homeTeam + " vs " + awayTeam);
            }


            Collections.rotate(teams.subList(1, teams.size()), 1);
        }

        System.out.println();
        System.out.println("İkinci Yarı Fikstürü:");
        System.out.println();


        Collections.reverse(teams);

        List<String> secondHalfFixture = new ArrayList<>();


        for (int round = 0; round < rounds; round++) {

            System.out.println();
            System.out.println("Hafta " + secondHalfCount + " Maçları :");
            System.out.println();
            secondHalfCount++;


            for (int i = 0; i < teamCount / 2; i++) {
                String homeTeam = teams.get(i);
                String awayTeam = teams.get(teamCount - 1 - i);
                secondHalfFixture.add(homeTeam + " vs " + awayTeam);
                System.out.println(homeTeam + " vs " + awayTeam);

            }


            Collections.rotate(teams.subList(1, teams.size()), 1);

        }


        return secondHalfFixture;
    }

    public void startFixture() {
        List<String> teams = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen fikstürünü çıkaracağınız takım sayısını girin : ");
        int numberOfTeams = input.nextInt();

        for (int i = 1; i <= numberOfTeams; i++) {
            System.out.println("Lütfen " + i + ". takımı girin : ");
            String keyboardTeam = input.next();
            teams.add(keyboardTeam);
        }

        List<String> firstHalfFixture = fiksturOlustur(teams);
    }


}