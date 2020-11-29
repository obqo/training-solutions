package stringbuilder.nameconcat;

public class NameBuilder {

    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        StringBuilder name = new StringBuilder("");
        if (title == null) {
            name.append(givenName);
        }
        else {
            name.append(title.getTitleString()).append(" ").append(givenName);
        }
        name.append(" ");
        if (middleName != null && !middleName.isEmpty()) {
            name.append(middleName).append(" ");
        }
        name.append(familyName);
        return name.toString();
    }

    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        StringBuilder name = new StringBuilder("");
        if (title == null) {
            name.append(familyName);
        }
        else {
            name.append(title.getTitleString()).append(" ").append(familyName);
        }
        name.append(" ");
        if (middleName != null && !middleName.isEmpty()) {
            name.append(middleName).append(" ");
        }
        name.append(givenName);
        return name.toString();
    }

    public String insertTitle(String name, Title title, String where) {
        StringBuilder newName = new StringBuilder(name);
        newName.insert(newName.indexOf(where), " " + title.getTitleString());
        return newName.toString();
    }

    public String deleteNamePart(String name, String delete) {
        StringBuilder newName = new StringBuilder(name);
        int index = newName.indexOf(delete);
        newName.delete(index, index + delete.length());
        return newName.toString();
    }

    public boolean isEmpty(String string) {
        return (string == null || string.isEmpty());
    }
}
