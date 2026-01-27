package composite.Assignment;

public abstract class OrganizationComponent {

    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    };

    public abstract double getSalary();

    public abstract void add(OrganizationComponent component);
    public abstract void remove(OrganizationComponent component);
    public abstract OrganizationComponent getChild(int index);
    public abstract String toXml(String indent);
}
