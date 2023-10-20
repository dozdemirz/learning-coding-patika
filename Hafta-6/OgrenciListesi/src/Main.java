import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        List<Integer> secilenOgrenciler = new ArrayList<>();
        String dosyaAdi = "secilen_ogrenciler.txt";


        Map<Integer, String> ogrenciMap = new HashMap<>();

        try {

            BufferedReader ogrenciDosyasi = new BufferedReader(new FileReader("ogrenci_listesi.txt"));
            String satir;
            int numara = 0;
            while ((satir = ogrenciDosyasi.readLine()) != null) {
                if (satir.matches("\\d+")) {
                    numara = Integer.parseInt(satir);
                } else {
                    ogrenciMap.put(numara, satir);
                }
            }
            ogrenciDosyasi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<Integer> tumOgrenciNumaralari = new ArrayList<>(ogrenciMap.keySet());


        while (!tumOgrenciNumaralari.isEmpty()) {

            int rastgeleIndex = ThreadLocalRandom.current().nextInt(tumOgrenciNumaralari.size());
            int secilenNumara = tumOgrenciNumaralari.get(rastgeleIndex);
            String secilenOgrenci = ogrenciMap.get(secilenNumara);


            secilenOgrenciler.add(secilenNumara);
            tumOgrenciNumaralari.remove(rastgeleIndex);

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true));
                writer.write(String.valueOf(secilenNumara));
                writer.write(" - ");
                writer.write(secilenOgrenci != null ? secilenOgrenci : "Bilinmeyen Öğrenci");
                writer.newLine();
                writer.close();
                System.out.println("Rastgele seçilen öğrenci " + secilenNumara + " numaralı öğrenci olan " + (secilenOgrenci != null ? secilenOgrenci : "Bilinmeyen Öğrenci") + " olarak kaydedildi.");
                System.out.println("Seçilen Öğrenciler: " + secilenOgrenciler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
