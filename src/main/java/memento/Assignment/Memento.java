package memento.Assignment;

import java.time.LocalDateTime;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private LocalDateTime timestamp;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.timestamp = LocalDateTime.now();
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String getDescription() {
        return "State changed at " + timestamp.toString();
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
