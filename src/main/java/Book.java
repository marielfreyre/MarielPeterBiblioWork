/**
 * Created by ptang on 8/4/15.
 */
public class Book {
    private boolean isAvailable;
    private String title;
    private String author;
    private Integer year;


    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;

        isAvailable = true;
    }

    public String toString() {
        return String.format("%s | %s | %d", title, author, year);
    }

    public boolean isInLibrary() {
        return isAvailable;
    }

    public void checkOut() {
        isAvailable = false;
    }

    public void checkIn() {
        isAvailable = true;
    }
}
