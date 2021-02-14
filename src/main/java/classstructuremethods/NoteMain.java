package classstructuremethods;

public class NoteMain {

    public static void main(String[] args) {
        Note note = new Note();

        note.setName("John Doe");
        note.setTopic("Java");
        note.setText("Methods");
        System.out.println(note.getName());
        System.out.println(note.getTopic());
        System.out.println(note.getText());

        System.out.println(note.getNoteText());
    }
}
