import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Book> bookSet = new TreeSet<>(new NameOrderComparable());
        bookSet.add(new Book("Ascend", 200, "Deniz", 2010));
        bookSet.add(new Book("Cyanide", 120, "Elif", 2001));
        bookSet.add(new Book("Brooke", 659, "Aslı", 2009));
        bookSet.add(new Book("Eclipse", 380, "Ömer", 2018));
        bookSet.add(new Book("Dire", 1500, "Bora", 2023));


        System.out.println("Kitapların A'dan Z'ye sıralaması: ");
        for (Book book : bookSet) {
            System.out.println("Kitap ismi: " + book.getName() + "     Sayfa sayısı: " + book.getPage() + "     Yazar: " + book.getAuthor() + "     Basım Yılı: " + book.getYear());
        }
        System.out.println("------------------------------------");

        TreeSet<Book> pageSort = new TreeSet<>(new PageOrderComparable());
        pageSort.addAll(bookSet);

        System.out.println("Kitapların sayfa sayısına göre sıralanması: ");
        for (Book book : pageSort) {
            System.out.println("Kitap ismi: " + book.getName() + "     Sayfa sayısı: " + book.getPage() + "     Yazar: " + book.getAuthor() + "     Basım Yılı: " + book.getYear());
        }
    }
}