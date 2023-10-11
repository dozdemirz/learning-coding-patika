
public class Main {
    public static void main(String[] args) {
        Fighter isik = new Fighter("Işık", 15, 32, 95, 0);
        Fighter deniz = new Fighter("Deniz", 13, 35, 100, 0);
        Ring r = new Ring(isik, deniz, 95, 100);
        r.run();
    }
}
