package week15.week15d03.Sen;

import java.time.LocalDate;

public class Post {

    private String title;
    private LocalDate publishedAt;
    private LocalDate deletedAt;
    private String content;
    private String owner;

    public Post(String title, LocalDate publishedAt, LocalDate deletedAt, String content, String owner) {
        this.title = title;
        this.publishedAt = publishedAt;
        this.deletedAt = deletedAt;
        this.content = content;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public LocalDate getDeletedAt() {
        return deletedAt;
    }

    public String getContent() {
        return content;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return title + " " + publishedAt + " " + deletedAt + " " + content + " " + owner ;
    }
}
