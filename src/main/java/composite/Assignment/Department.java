package composite.Assignment;

import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent {

    private List<OrganizationComponent> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public double getSalary() {
        double totalSalary = 0;
        for (OrganizationComponent child : this.children) {
            totalSalary += child.getSalary();
        }
        return totalSalary;
    }

    @Override
    public void add(OrganizationComponent component) {
        this.children.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        this.children.remove(component);
    }

    @Override
    public OrganizationComponent getChild(int index) {
        return this.children.get(index);
    }

    @Override
    public String toXml(String indent) {
        StringBuilder xml = new StringBuilder();
        xml.append(indent).append("<Department name=\"")
                .append(getName())
                .append("\">\n");
        for (OrganizationComponent child : this.children) {
            xml.append(child.toXml(indent + "  "));
        }
        xml.append(indent).append("</Department>\n");
        return xml.toString();
    }
}
