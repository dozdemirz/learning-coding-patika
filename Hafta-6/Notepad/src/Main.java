import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Bir metin giriniz: ");
        String metin = input.nextLine();

        try {
            FileWriter fileWriter = new FileWriter("notlar.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(metin);

            fileWriter.close();
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            FileReader fileReader = new FileReader("notlar.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String okunanMetin = bufferedReader.readLine();

            while (okunanMetin != null) {
                System.out.println(okunanMetin);
                okunanMetin = bufferedReader.readLine();
            }

            fileReader.close();
            bufferedReader.close();
        } catch (Exception a) {
            System.out.println(a.getMessage());
        }
    }
}
