/*
Készítsünk olyan osztályt, ami egy könyvtárban tárolt könyvek szoftveres menedzselését valósítja meg.
A könyvtárat feltöltjük könyvekkel, és kereséshez cím vagy szerő szerint rendezhetjük a könyveket.
Alapértelmezett a cím szerinti rendezés. Egy külön metódusban valósítsuk meg a könyvcímek magyar
ékezetes karaktereket is figyelembe vevő rendezését. Csak a könyvcímek kellenek, nem a könyvek!
Megvalósítás
Book osztály int regNumber String title és String author attribútumokkal.
A public int compareTo(Book o) metódust az igényeknek megfelelően készítsük el.
OrderedLibrary osztály List<Book> libraryBooks attribútummal. Ezt konstruktorból tudjuk feltölteni.
publikus metódusok:
 public OrderedLibrary(List<Book> libraryBooks)
 public List<Book> orderedByTitle()
 public List<Book> orderedByAuthor()
 public List<String> orderedByTitleLocale(Locale locale)
Egy külön osztályban (AuthorComparator) valósítsuk meg a szerző szerint történő rendezéshez szükséges Comparator osztályt.
Bónusz feladat - Collator
Az ékezetes karaktereket is figyelembe vevő String rendezéshez a Collator osztály egy példányára lesz szükségünk.
Nézz utána, ez hogyan állítható elő és hogyan paraméterezhető!
Bónusz feladat - Comparator
A Comparator objektumot többnyire névtelen osztály példányaként állítjuk elő. Nézz utána, ez hogyan valósítható meg!
 */
package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {

    private final List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByTitle() {
        List<Book> sortedBooksByTitle = new ArrayList<>(libraryBooks);
        Collections.sort(sortedBooksByTitle);
        return sortedBooksByTitle;
    }

    public List<Book> orderedByAuthor() {
        List<Book> sortedBooksByAuthor = new ArrayList<>(libraryBooks);
        //Collections.sort(sortedBooksByAuthor, new AuthorComparator());
        Collections.sort(sortedBooksByAuthor, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        });
        return sortedBooksByAuthor;
    }

    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> sortedBooksByTitleLocale = new ArrayList<>();
        for (Book book : libraryBooks) {
            sortedBooksByTitleLocale.add(book.getTitle());
        }
        Collections.sort(sortedBooksByTitleLocale, Collator.getInstance(locale));
        return sortedBooksByTitleLocale;
    }

}
