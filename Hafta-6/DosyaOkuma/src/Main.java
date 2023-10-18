import java.io.*;

public class Main {
    public static void main(String[] args)  {

        String arr = "5\n10\n20\n12\n33";
        int toplam = 0;

        try {
            FileWriter fileWriter = new FileWriter("sayi.txt");
            BufferedWriter buffWri = new BufferedWriter(fileWriter);
            buffWri.write(arr);

            buffWri.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            FileReader fileReader = new FileReader("sayi.txt");
            BufferedReader buffRead = new BufferedReader(fileReader);

            String line = buffRead.readLine();
            while (line != null) {
                int sayi = Integer.parseInt(line);
                toplam += sayi;
                line = buffRead.readLine();
            }

            buffRead.close();
        }catch (Exception a) {
            System.out.println(a.getMessage());
        }

        System.out.println("Toplam : " + toplam);


    }
}