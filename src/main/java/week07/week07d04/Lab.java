/*
Hozz létre egy Lab nevű osztályt, ami azt tárolja el, hogy melyik feladattal készültél el. Három attribútuma:
title ami a tananyag neve, egy completed, hogy elkészültél-e vele, és a completedAt , ami azt tárolja, hogy mikor. Legyen két
konstruktora! Az egyik csak a címet várja, ekkor úgy állítsa be a példányt, hogy még nem készültél el. Legyen egy másik, ami várja
a címet és a dátumot. Ekkor azt állítsa be, hogy elvégezted a gyakorlati feladatot. Írj egy complete metódust, ami kap egy dátumot,
és beállítja, hogy elvégezted a gyakorlati feladatot. Legyen egy complete metódusa, ami semmit nem vár, ez azt állítja be, hogy
MOST végezted el a gyakorlati feladatot. Írd meg a toString metódusát is!
 */
package week07.week07d04;

import java.time.LocalDate;

public class Lab {

    private String title;
    private boolean completed;
    private LocalDate completedAt;

    public Lab(String title) {
        this.title = title;
        this.completed = false;
    }

    public Lab(String title, LocalDate completedAt) {
        this.title = title;
        complete(completedAt);
    }

    public void complete(LocalDate date) {
        this.completedAt = date;
        this.completed = true;
    }

    public void complete() {
        complete(LocalDate.now());
    }

    @Override
    public String toString() {
        return "title='" + title +
                ", completed=" + completed +
                ", completedAt=" + completedAt;
    }
}
