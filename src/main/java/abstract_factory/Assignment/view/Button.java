package abstract_factory.Assignment.view;

public abstract class Button {
    public String text;
    public Button(String text) {
        this.text = text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public abstract void display();
}
