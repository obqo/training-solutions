/*
Adott az alábbi osztály:
java
public class Post {
    private String title;
    private LocalDate publishedAt;
    private LocalDate deletedAt;
    private String content;
    private String owner;
}
Implementáljunk a PostFinder osztályban egy public List<Post> findPosts(String user) metódust az alábbi módon:
- A Post publishedAt dátuma korábbi kell, hogy legyen, mint a LocalDate.now()
- Ha a Post publishedAt dátuma későbbi, mint a LocalDate.now(),
akkor csak azokat a Post-okat adjuk vissza, melyek owner-e megegyezik a megadott user-rel.
- A content és a title nem lehet üres
- A deletedAt értéke null kell, hogy legyen, vagy későbbi, mint a LocalDate.now().
- Használjunk stream-eket az implementációhoz!
 */
package week15.week15d03.Sen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFinder {

    private final List<Post> postList;

    public PostFinder(List<Post> postList) {
        this.postList = postList;
    }

    public List<Post> findPosts(String user) {
        List<Post> result = new ArrayList<>();
        for (Post post : postList) {
            if (isValid(post, user)) {
                result.add(post);
            }
        }
        return result;
    }

    private boolean isValid(Post post, String user) {
        return  (post.getPublishedAt().isBefore(LocalDate.now()) ||
                (post.getPublishedAt().isAfter(LocalDate.now()) && post.getOwner().equals(user))) &&
                isNotEmpty(post.getContent()) &&
                isNotEmpty(post.getTitle()) &&
                (post.getDeletedAt() == null || post.getDeletedAt().isAfter(LocalDate.now()));
    }

    private boolean isNotEmpty(String str) {
        return str != null && !str.isEmpty();
    }

    public static void main(String[] args) {
        PostFinder postFinder = new PostFinder(List.of(
                new Post("title1", LocalDate.of(2020, 12, 12),
                        LocalDate.of(2021, 12, 12), "content1", "owner1"),
                new Post("title1", LocalDate.of(2020, 12, 12),
                        null, "content1", "owner1"),
                new Post("title1", LocalDate.of(2020, 12, 12),
                        LocalDate.of(2020, 12, 12), "content1", "owner2"),
                new Post("title2", LocalDate.of(2021, 12, 12),
                        LocalDate.of(2020, 12, 12), "content2", "owner2"),
                new Post("", LocalDate.of(2020, 12, 12),
                        LocalDate.of(2020, 12, 12), "content3", "owner1"),
                new Post("title4", LocalDate.of(2020, 12, 12),
                        LocalDate.of(2020, 12, 12), "", "owner1"),
                new Post("", LocalDate.of(2020, 12, 12),
                        LocalDate.of(2020, 12, 12), "", "owner1"),
                new Post("title5", LocalDate.of(2020, 12, 12),
                        LocalDate.of(2020, 12, 12), null, "owner1")));
        System.out.println(postFinder.findPosts("owner1"));
    }
}
