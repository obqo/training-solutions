package debug.employees;

import java.util.ArrayList;
import java.util.List;

public class CompanyMain {

    public static void main(String[] args) {

        Employee employee1 = new Employee("John", 1987);
        Employee employee2 = new Employee("Jane", 1978);
        Employee employee3 = new Employee("Jack", 1984);

        Company company = new Company(new ArrayList<>());

        company.addEmployee(employee1);
        company.addEmployee(employee2);
        company.addEmployee(employee3);

        Employee jack = company.findEmployeeByName("Jack");
        System.out.println(jack.getName() + " " + jack.getYearOfBirth());

        List<String> names = company.listEmployeeNames();
        System.out.println(names);

    }
}
