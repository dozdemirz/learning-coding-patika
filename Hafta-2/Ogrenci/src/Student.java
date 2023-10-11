public class Student {
    Course music;
    Course math;
    Course history;
    String name;
    String studentNo;
    String classes;
    double avarage;
    boolean isPass;

    public Student(String name, String studentNo, String classes, Course music, Course math, Course history) {
        this.name = name;
        this.studentNo = studentNo;
        this.classes = classes;
        this.music = music;
        this.math = math;
        this.history = history;
    }

    public void addExamNote(int math, int history, int music) {

        if (math >= 0 && math <= 100) {
            this.math.note = math;
        }

        if (history >= 0 && history <= 100) {
            this.history.note = history;
        }

        if (music >= 0 && music <= 100) {
            this.music.note = music;
        }

    }

    public void isPass() {
        if (this.math.note == 0 && this.history.note == 0 && this.music.note == 0) {
            System.out.println("Notlar girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = (this.music.note + this.history.note + this.math.note) / 3.0;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote() {
        System.out.println("=========================");
        System.out.println("Student : " + this.name);
        System.out.println("Math Grade : " + this.math.note);
        System.out.println("Music Grade : " + this.music.note);
        System.out.println("History Grade : " + this.history.note);
    }
}
