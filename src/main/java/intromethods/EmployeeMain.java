package intromethods;

public class EmployeeMain {

    public static void main(String[] args) {

        Employee employee = new Employee("John Doe", 2010, 3000);
        System.out.println(employee);
        employee.raiseSalary(500);
        System.out.println(employee);
        employee.setName("Jane Doe");
        System.out.println(employee);
    }
}
