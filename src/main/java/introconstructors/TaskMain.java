package introconstructors;

public class TaskMain {

    public static void main(String[] args) {

        Task task = new Task("xyz", "abc");
        task.setDuration(30);
        task.start();
        System.out.println(task.getTitle() + " " + task.getDescription() + " " + task.getDuration() + " " + task.getStartDateTime());

        /*
        Task task1 = new Task("Project database", "Create database initial schema");

        System.out.println("Title: " + task1.getTitle());
        System.out.println("Description: " + task1.getDescription());

        task1.start();
        task1.setDuration(100);

        System.out.println("Started at "
                + task1.getStartDateTime()
                + " and took "
                + task1.getDuration()
                + " minutes to finish.");
         */
    }
}
