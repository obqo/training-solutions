/*
Készítsünk olyan osztályt, ami egy könyvtárban tárolt könyvek szoftveres rendezéseit valósítja meg.
A könyvtárban a könyveket tömb segítségével tároljuk, ezt kell rendezni igény esetén különböző szempontok alapján.
Megvalósítás
Book osztály int id String title és String author attribútumokkal.
A public int compareTo(Book o) metódust az igényeknek megfelelően készítsük el. Alapértelmezett az id szerinti rendezés.
OrderedArrayLibrary osztály private Book[] bookArray attribútummal. Ezt konstruktorból tudjuk feltölteni.
publikus metódusok:
 public OrderedArrayLibrary(Book[] bookArray)
 public Book[] sortingById()
 public Book[] sortingByTitle()
A rendezés során az eredeti tömb egy másolatát adjuk vissza, a megfelelő szempont szerint rendezve!
Tipp
A rendezéshez szükséges Comparator objektumot előállíthatjuk külön osztályból, vagy névtelen osztályból is.
 */
package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedArrayLibrary {

    private final Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book[] sortingById() {
        Book[] sortedArray = new Book[bookArray.length];
        System.arraycopy(bookArray, 0, sortedArray, 0, bookArray.length);
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    public Book[] sortingByTitle() {
        Book[] sortedArray = new Book[bookArray.length];
        System.arraycopy(bookArray, 0, sortedArray, 0, bookArray.length);
        Arrays.sort(sortedArray, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return sortedArray;
    }

}