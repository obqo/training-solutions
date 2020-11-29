package stringbuilder.nameconcat;

public enum Title {
    MR("Mr."), MS("Ms."), DR("Dr."), PROF("Prof.");

    private String titleString;

    Title(String titleString) {
        this.titleString = titleString;
    }

    public String getTitleString() {
        return titleString;
    }
}
