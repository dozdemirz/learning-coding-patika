
public class Main {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("Ekrem", "MATH", "666");
        Teacher t2 = new Teacher("Müge", "MUS", "664");
        Teacher t3 = new Teacher("Barış", "HIST", "665");

        Course music = new Course("Music", "102", "MUS");
        Course history = new Course("History", "103", "HIST");
        Course math = new Course("Math", "102", "MATH");

        math.addTeacher(t1);
        music.addTeacher(t2);
        history.addTeacher(t3);

        Student s1 = new Student("Bilge", "195", "3", music, history, math);
        s1.addExamNote(60, 40, 30);
        s1.isPass();

        Student s2 = new Student("Adem", "190", "3", music, history, math);
        s2.addExamNote(90, 80, 75);
        s2.isPass();

        Student s3 = new Student("Çiçek", "199", "3", music, history, math);
        s3.addExamNote(100, 40, 20);
        s3.isPass();


    }
}
