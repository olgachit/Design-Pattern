package prototype.Assignment;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
        }
    }

    public void setTargetAudience(String audience) {
        this.targetAudience = audience;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    @Override
    public Recommendation clone() {
        Recommendation copy = new Recommendation(this.targetAudience);

        for (Book book : books) {
            copy.books.add(book.clone());
        }

        return copy;
    }

    public void display() {
        System.out.println("Audience: " + targetAudience);
        for (int i = 0; i < books.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + books.get(i));
        }
    }
}