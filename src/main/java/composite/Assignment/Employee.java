package composite.Assignment;

public class Employee extends OrganizationComponent {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        super.getName();
        return salary;
    }

    @Override
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }
    @Override
    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }
    @Override
    public OrganizationComponent getChild(int index) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }
    @Override
    public String toXml(String indent) {
        return indent + "<Employee name=\"" + this.name + "\" salary=\"" + this.salary + "\" />\n";
    }
}
