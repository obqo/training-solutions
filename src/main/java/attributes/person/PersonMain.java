package attributes.person;

public class PersonMain {

    public static void main(String[] args) {

        //PersonMain personMain = new PersonMain();
        Person person = new Person("Kiss Béla", "123456AA");
        Address address = new Address("Hungary", "Siófok", "Fő út 34", "H-8600");
        person.moveTo(address);
        System.out.println(person.personToString());
        System.out.println(person.getAddress().addressToString());

        person.correctData("Nagy Csilla", "AA123456");
        System.out.println(person.personToString());
        person.getAddress().correctData("Hungary", "Siófok", "Ady Endre u. 12", "H-8600");
        System.out.println(person.getAddress().addressToString());
    }
}
