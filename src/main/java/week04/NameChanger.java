package week04;

public class NameChanger {

    private String fullname;

    public NameChanger(String fullname) {
        if (fullname == null || fullname.isBlank()) {
            throw new IllegalArgumentException("Invalid name:" + fullname);
        }
        else {
            this.fullname = fullname;
        }
    }

    public String getFullname() {
        return fullname;
    }

    public void changeFirstName(String firstname) {
        fullname = fullname.replace(fullname.substring(0, fullname.indexOf(" ")), firstname);
    }
}
