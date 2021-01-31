/*
Egy hibabejelentő rendszer egy alkalmazással kapcsolatosan bejelentett hibákat tartalmazza.
Legyen egy clone.issuetracker.Issue osztály, mely a rendszerben lévő hibákat reprezentálja, egy name attribútummal,
LocalDateTime time és egy Status status attribútummal. A Status egy enum NEW, IN_PROGRESS és CLOSED értékekkel.
Az Issue tartalmazzon egy clone.issuetracker.Comment listát. A Comment tartalmazzon egy String text és
egy LocalDateTime time attribútumot.
A Issue osztálynak legyen egy copy konstruktora, mely kap egy másik Issue példányt, valamint egy CopyMode enum értéket.
Ez vagy CopyMode.WITH_COMMENTS vagy CopyMode.WITHOUT_COMMENTS. Előbbi esetben a megjegyzéseket is másolja, utóbbi esetben nem.
A megjegyzések is copy konstruktorral legyenek másolhatóak, és ez kerüljön meghívásra (deep copy).
 */
package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {

    private final String name;
    private final LocalDateTime time;
    private final Status status;
    private List<Comment> comments = new ArrayList<>();

    public Issue(String name, LocalDateTime time, Status status) {
        this.name = name;
        this.time = time;
        this.status = status;
    }

    public Issue(Issue issue, CopyMode copyMode) {
        this.name = issue.name;
        this.time = issue.time;
        this.status = issue.status;
        if (copyMode == CopyMode.WITH_COMMENTS) {
            List<Comment> copyComments = new ArrayList<>();
            for (Comment comment : issue.comments) {
                copyComments.add(new Comment(comment));
            }
            this.comments = copyComments;
        }
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
