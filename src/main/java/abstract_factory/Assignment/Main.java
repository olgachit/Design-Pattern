package abstract_factory.Assignment;

import abstract_factory.Assignment.view.*;

public class Main {
    public static void main(String[] args) {

        UIFactory factory = new AFactory();
        // UIFactory factory = new BFactory();

        Button button = factory.createButton("OK");
        TextField textField = factory.createTextField("Name");
        Checkbox checkbox = factory.createCheckbox("Accept");

        button.display();
        textField.display();
        checkbox.display();

        System.out.println();

        button.setText("Submit");
        textField.setText("Email");
        checkbox.setText("Subscribe");

        button.display();
        textField.display();
        checkbox.display();
    }
}

