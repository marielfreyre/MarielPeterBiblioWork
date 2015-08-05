import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cramsden on 8/5/15.
 */
public class Console {
    private Library library;
    private PrintStream printStream;
    private Map<String,Command> menuItems;

    public Console(Library library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
        menuItems = new HashMap<>();
        menuItems.put("1", new ListBooksCommand(this));
    }

    public void openLibrary(){
        printStream.println(library.open());
    }


    public void listAllBooks() {
        for (Book book : library.listAllBooks()) {
            printStream.println(book);
        }
    }

    public void runLibrary() {
        openLibrary();
        listAllBooks();
    }


    public void generateMenu() {
        for (Map.Entry<String, Command> menuItem : menuItems.entrySet()) {
            printStream.println(menuItem);
        }
    }

    public String getUserInput() {
        return "";
    }
}
