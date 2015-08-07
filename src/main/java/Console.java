import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

/**
 * Created by cramsden on 8/5/15.
 */
public class Console {
    private Library library;
    private PrintStream printStream;
    private BufferedReader reader;
    private Map<String, Command> menuItems;
    private boolean isConsoleClose = false;
    private Menu menu;

    public Console(Library library, PrintStream printStream, BufferedReader reader, Map<String, Command> menuItems, Menu menu) {
        this.library = library;
        this.printStream = printStream;
        this.reader = reader;
        this.menuItems = menuItems;
        this.menu = menu;
    }

    private void openLibrary() {
        printStream.println(library.open());
    }


    public void runLibrary() {
        openLibrary();
        //generateMenu();

        String userInput;

        while (!isConsoleClose) {
            menu.print();
            userInput = getUserInput();
            menu.executeUserInput(userInput);
        }
    }


    public void quit() {
        isConsoleClose = true;
    }


    public String getUserInput() {

        printStream.println("Please Select a Number from the Menu:");
        String userInput = "";

        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            printStream.println("Could not read user's input.");
        }

        return userInput;


    }

}
