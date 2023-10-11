public class Course {
    String name;
    String code;
    String prefix;
    int note;
    Teacher teacher;


    public Course (String name, String code, String prefix) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.note = 0;

    }
    public void addTeacher(Teacher teacher) {
        if (this.prefix.equals(teacher.branch)) {
            this.teacher = teacher;
            System.out.println("İşlem başarılı");
        }else {
            System.out.println(teacher.name + " bu dersi veremez.");
        }
    }

    public void printTeacher () {
        if (teacher != null) {
            System.out.println(this.name + "dersinin akademisyeni : " + teacher.name);
        }else {
            System.out.println(this.name + "dersine akademisyen atanmamıştır.");
        }
    }

}
