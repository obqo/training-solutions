package references.parameters;

public class ReferencesMain {

    public static void main(String[] args) {

        Person person1;
        Person person2;
        Person person3 = new Person("Jane Doe", 33);
        person1 = person3;
        person2 = person1;
        person2.setName("John Doe");
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        int nr1;
        int nr2;
        nr1 = 24;
        nr2 = nr1;
        nr2++;
        System.out.println(nr1);
        System.out.println(nr2);

        Person person4 = new Person("Jack Doe", 22);
        person1 = person4;
        System.out.println(person1);
        System.out.println(person4);

    }
}
