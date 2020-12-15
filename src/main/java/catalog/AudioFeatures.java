package catalog;

import java.util.ArrayList;
import java.util.List;

import static catalog.Validators.isBlank;
import static catalog.Validators.isEmpty;

public class AudioFeatures implements Feature {

    private final String title;
    private final int length;
    private List<String> performers;
    private List<String> composer;

    public AudioFeatures(String title, int length, List<String> performers) {
        if (isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (length < 1) {
            throw new IllegalArgumentException("Invalid length");
        }
        if (isEmpty(performers)) {
            throw new IllegalArgumentException("Empty list");
        }
        this.title = title;
        this.length = length;
        this.performers = performers;
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        this(title, length, performers);
        this.composer = composer;
    }

    @Override
    public List<String> getContributors() {
        List<String> newList = new ArrayList<>();
        if (!isEmpty(composer)) {
            newList.addAll(composer);
        }
        if (!isEmpty(performers)) {
            newList.addAll(performers);
        }
        return newList;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}
