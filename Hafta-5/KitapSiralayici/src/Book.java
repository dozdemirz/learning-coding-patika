import java.util.Comparator;
public class Book  {
    String name;
    int page;
    String author;
    int year;

    public Book(String name, int page, String author, int year) {
        this.name = name;
        this.page = page;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getPage() {
        return page;
    }

}
