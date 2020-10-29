package classsctructuremethods;

public class ClientMain {

    public static void main(String[] args) {
        Client client = new Client();

        client.setName("John Doe");
        client.setYear(1980);
        client.setAddress("Hawaii");
        System.out.println(client.getName());
        System.out.println(client.getYear());
        System.out.println(client.getAddress());

        client.migrate("Tokio");
        System.out.println(client.getAddress());

    }
}
