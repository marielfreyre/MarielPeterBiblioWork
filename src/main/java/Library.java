import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/*
 * This Java source file was auto generated by running 'gradle buildInit --type java-library'
 * by 'ptang' at '8/4/15 1:34 PM' with Gradle 2.5
 *
 * @author ptang, @date 8/4/15 1:34 PM
 */
public class Library {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private List<Book> books;

//    //public Library() {
//        this(new ArrayList<Book>());
//    }

    public Library(List<Book> books, PrintStream printStream, BufferedReader bufferedReader) {
        this.books = books;
        this.printStream = printStream;

        this.bufferedReader = bufferedReader;
    }


    public String open() {
        return "Welcome to the Library! Biblioteca is available!";
    }


    public void listAllBooks() {
        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);
            if (currentBook.canBeCheckedOut()) {
                printStream.println((i+1) +" | " + currentBook);
            }
        }


    }

    public void checkOutBook() {
        printStream.println("Please enter the book ID:");
        String userInput = null;
        try {
            userInput = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int bookID = parseInt(userInput) - 1;
        books.get(bookID).checkOut();
        printStream.println("Thank you! Enjoy the book");

    }

    public void addBook(Book book1) {
        books.add(book1);
    }



//    public void generateMenu() {
//
//    }
}
