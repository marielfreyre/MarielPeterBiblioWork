import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        List<Book> listOfBooks = generateBookList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library(listOfBooks, System.out, reader);

        Map<String, Command> menuItems = generateMenuItems(library);
        Menu menu = new Menu(System.out, menuItems, reader);
        BibliotecaLauncher bibliotecaLauncher = new BibliotecaLauncher(library, System.out, menu);

        bibliotecaLauncher.runLibrary();
    }

    private static Map<String, Command> generateMenuItems(Library biblioteca) {
        Map <String, Command> menuItems = new HashMap<>();
        menuItems.put("L", new ListBooksCommand(biblioteca,System.out));
        menuItems.put("C", new CheckoutCommand(biblioteca));
        menuItems.put("R", new ReturnCommand(biblioteca));
        menuItems.put("Q", new QuitCommand());
        return menuItems;
    }

    private static List<Book> generateBookList() {
        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Catch-22","Joseph Heller", 1961));
        listOfBooks.add(new Book("Harry Potter and the Sorcerer's Stone", "JK Rowling", 1997));
        listOfBooks.add(new Book("Notes from the Underground", "Fyodor Dostoevsky", 1864));
        listOfBooks.add(new Book("Head First Java", "Bert Bates and Kathy Sierra", 2003));
        return listOfBooks;
    }

}
