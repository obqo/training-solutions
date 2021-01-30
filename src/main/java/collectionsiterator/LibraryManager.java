/*
Készítsünk olyan osztályt, ami egy könyvtárban tárolt könyvek szoftveres menedzselését valósítja meg.
A könyvtárat feltöltjük egyedi könyvekkel, és egyedi regisztrációs szám alapján kikereshetjük,
eltávolíthatjuk a könyvtár állományából, illetve szerző szerint kigyűjthetünk könyveket.
Megvalósítás
Book osztály int regNumber String title és String author attribútumokkal.
Az equals() és hashCode() metódusokat az igényeknek megfelelően készítsük el, egyedi a regNumber attribútum.
LibraryManager osztály Set<Book> libraryBooks attribútummal. Ezt konstruktorból tudjuk feltölteni.
publikus metódusok:
 public Book findBookByRegNumber(int regNumber)
 public int removeBookByRegNumber(int regNumber)
 public Set<Book> selectBooksByAuthor(String author)
Mindhárom metódus saját MissingBookException-t (RuntimeException) dob, ha a regisztrációs számnak megfelelő könyv nem található,
vagy adott szerzővel nem található könyv.
Tipp
Használjunk iterátoros bejárást a könyvek megtalálására és kigyűjtésére. A tesztelés segítésére készítsünk egy
public int libraryBooksCount() metódust is, ami visszaadja a Book kollekció méretét.
 */
package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {

    private final Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber) {
        Book result;
        Iterator<Book> iteratorBook= libraryBooks.iterator();
        while (iteratorBook.hasNext()) {
            result = iteratorBook.next();
            if (result.getRegNumber() == regNumber) {
                return result;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public int removeBookByRegNumber(int regNumber) {
        Iterator<Book> iteratorBook= libraryBooks.iterator();
        while (iteratorBook.hasNext()) {
            if (iteratorBook.next().getRegNumber() == regNumber) {
                iteratorBook.remove();
                return regNumber;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> result = new HashSet<>();
        Book book;
        Iterator<Book> iteratorBook= libraryBooks.iterator();
        while (iteratorBook.hasNext()) {
            book = iteratorBook.next();
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        if (result.size() > 0) {
            return result;
        }
        throw new MissingBookException("No books found by " + author);
    }

    public int libraryBooksCount() {
        return libraryBooks.size();
    }
}
