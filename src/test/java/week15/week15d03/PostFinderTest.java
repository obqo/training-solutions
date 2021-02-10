package week15.week15d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

    @Test
    void findPostsFor() {

        PostFinder postFinder = new PostFinder(List.of(
                new Post("title0", LocalDate.of(2020, 12, 12), "content1", "owner1"),
                new Post("title1", LocalDate.of(2020, 12, 12), "content1", "owner2"),
                new Post("title2", LocalDate.of(2021, 12, 12), "content2", "owner2"),
                new Post("", LocalDate.of(2020, 12, 12), "content3", "owner1"),
                new Post("title4", LocalDate.of(2020, 12, 12), "", "owner1"),
                new Post("", LocalDate.of(2020, 12, 12), "", "owner1"),
                new Post("title5", LocalDate.of(2020, 12, 12), null, "owner1")));
        //System.out.println(postFinder.findPostsFor("owner1"));
        assertEquals(1, postFinder.findPostsFor("owner1").size());
        assertEquals("title0", postFinder.findPostsFor("owner1").get(0).getTitle());
        PostFinder postFinder2 = new PostFinder(List.of(
                new Post("title0", LocalDate.of(2020, 12, 12), "content1", null)));
        assertThrows(IllegalArgumentException.class, () -> postFinder2.findPostsFor("owner"));
    }
}