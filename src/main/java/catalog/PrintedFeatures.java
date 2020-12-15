package catalog;

import java.util.List;

import static catalog.Validators.isBlank;
import static catalog.Validators.isEmpty;

public class PrintedFeatures implements Feature{

    private List<String> authors;
    private final int numberOfPages;
    private final String title;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (numberOfPages < 1) {
            throw new IllegalArgumentException("Invalid number of pages");
        }
        if (isEmpty(authors)) {
            throw new IllegalArgumentException("Empty list");
        }
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    @Override
    public List<String> getContributors() {
        return authors;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
