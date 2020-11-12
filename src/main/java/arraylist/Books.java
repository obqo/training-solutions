package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private List<String> titles = new ArrayList<>();

    public void add(String title) {

        titles.add(title);
    }

    public List<String> findAllByPrefix(String prefix) {

        List<String> found = new ArrayList<>();
        for (String title : titles) {
            if (title.startsWith(prefix)) {
                found.add(title);
            }
        }
        return found;
    }

    public void removeByPrefix(String prefix) {

        List<String> delete = new ArrayList<>();
        for (String title : titles) {
            if (title.startsWith(prefix)) {
                delete.add(title);
            }
        }
        titles.removeAll(delete);
    }

        public List<String> getTitles(){

        return titles;
    }

    public static void main(String[] args) {

        Books books = new Books();
        books.add("Matematika");
        books.add("Fizika");
        books.add("Kémia");
        books.add("Fizikoterápia");
        System.out.println(books.getTitles());
        System.out.println(books.findAllByPrefix("Fiz"));

        books.removeByPrefix("Fiz");
        System.out.println(books.getTitles());
    }
}
