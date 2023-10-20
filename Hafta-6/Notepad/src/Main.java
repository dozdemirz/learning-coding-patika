import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<Integer> secilenOgrenciler = new ArrayList<>();
        String dosyaAdi = "secilen_ogrenciler.txt";
        String dataDosyaAdi = "secilen_ogrenciler_data.txt";

        // Öğrenci isimlerini ve numaralarını içerecek olan Map
        Map<Integer, String> ogrenciMap = new HashMap<>();

        try {
            // Öğrenci bilgilerini içeren dosyayı oku
            BufferedReader ogrenciDosyasi = new BufferedReader(new FileReader("ogrenci_listesi.txt"));
            String satir;
            while ((satir = ogrenciDosyasi.readLine()) != null) {
                String[] parcalar = satir.split(" - ");
                if (parcalar.length == 2) {
                    int numara = Integer.parseInt(parcalar[0]);
                    String isim = parcalar[1];
                    ogrenciMap.put(numara, isim);
                }
            }
            ogrenciDosyasi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int secilenNumara;

        do {
            secilenNumara = random.nextInt(60) + 1;
        } while (secilenOgrenciler.contains(secilenNumara));

        String secilenOgrenci = ogrenciMap.get(secilenNumara);

        secilenOgrenciler.add(secilenNumara);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true));
            writer.write(String.valueOf(secilenNumara));
            writer.write(" - ");
            if (secilenOgrenci != null) {
                writer.write(secilenOgrenci);
            } else {
                writer.write("Bilinmeyen Öğrenci");
            }
            writer.newLine();
            writer.close();
            System.out.println("Rastgele seçilen öğrenci " + secilenNumara + " numaralı öğrenci olan " + secilenOgrenci + " olarak kaydedildi.");
            System.out.println("Seçilen Öğrenciler: " + secilenOgrenciler);

            // Seçilen öğrencinin verilerini data dosyasına kaydet
            BufferedWriter dataWriter = new BufferedWriter(new FileWriter(dataDosyaAdi, true));
            dataWriter.write("Numara: " + secilenNumara + ", İsim: " + secilenOgrenci);
            dataWriter.newLine();
            dataWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
