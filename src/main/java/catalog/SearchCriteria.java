package catalog;

import static catalog.Validators.isBlank;

public class SearchCriteria {

    public final String title;
    public final String contributor;

    private SearchCriteria(String title, String contributor) {
        this.title = title;
        this.contributor = contributor;
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        if (isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (isBlank(contributor)) {
            throw new IllegalArgumentException("Empty contributor");
        }
        return new SearchCriteria(title, contributor);
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (isBlank(contributor)) {
            throw new IllegalArgumentException("Empty contributor");
        }
        return new SearchCriteria( null, contributor);
    }

    public static SearchCriteria createByTitle(String title) {
        if (isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        return new SearchCriteria(title, null);
    }

    public boolean hasContributor() {
        return !(contributor == null || contributor.isBlank());
    }

    public boolean hasTitle() {
        return !(title == null || title.isBlank());
    }

}
