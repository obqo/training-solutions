package stringconcat.nameconcat;

public class Name {

    private String familyName;
    private String middleName;
    private String givenName;
    private Title title;

    public Name(String familyName, String middleName, String givenName, Title title) {
        this(familyName, middleName, givenName);
        this.title = title;
    }

    public Name(String familyName, String middleName, String givenName) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public String concatNameWesternStyle() {
        String name;
        if (title == null) {
            name = givenName;
        }
        else {
            name = title.getTitleString().concat(" ").concat(givenName);
        }
        name = name.concat(" ");
        if (middleName != null && !middleName.isEmpty()) {
            name = name.concat(middleName).concat(" ");
        }
        name = name.concat(familyName);
        return name;
    }

    public String concatNameHungarianStyle() {
        String name = "";
        if (title == null) {
            name = familyName;
        }
        else {
            name += title.getTitleString() + (" ") + (familyName);
        }
        name += " ";
        if (middleName != null && !middleName.isEmpty()) {
            name += middleName + " ";
        }
        name += givenName;
        return name;
    }

    public boolean isEmpty(String string) {
        return (string == null ||string.isEmpty());
    }
}
