package composite.Assignment;

public class Main {

    public static void main(String[] args) {

        OrganizationComponent department1 = new Department("Head Office");
        OrganizationComponent department2 = new Department("Sales Department");
        OrganizationComponent department3 = new Department("HR Department");

        OrganizationComponent employee1 = new Employee("Alice", 70000);
        OrganizationComponent employee2 = new Employee("Bob", 50000);
        OrganizationComponent employee3 = new Employee("Charlie", 60000);

        department3.add(employee1);
        department2.add(employee2);
        department2.add(employee3);
        department1.add(department2);
        department1.add(department3);
        System.out.println("Organization Structure in XML:");
        System.out.println(department1.toXml(""));
        System.out.println("Salary in " + department1.getName() + ": " + department1.getSalary());

        department1.remove(department2);
        System.out.println(department1.toXml(""));
        System.out.println("Salary in " + department1.name + ": " + department1.getSalary());

    }
}
