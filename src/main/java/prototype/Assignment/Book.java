package prototype.Assignment;

public class Book implements Prototype {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    @Override
    public Book clone() {
        return new Book(title, author, genre, publicationYear);
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + genre + ", " + publicationYear + ")";
    }
}