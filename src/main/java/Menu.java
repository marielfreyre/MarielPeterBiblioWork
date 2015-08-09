import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

/**
 * Created by mfreyre on 8/7/15.
 */
public class Menu {

    private boolean amRunning;
    private PrintStream printStream;
    private Map<String, Command> menuItems;
    private BufferedReader reader;

    public Menu(PrintStream printStream, Map<String, Command> menuItems, BufferedReader reader) {

        this.printStream = printStream;
        this.menuItems = menuItems;
        this.reader = reader;
        amRunning = true;
    }

    public void print() {

        for (Map.Entry<String, Command> menuItem : menuItems.entrySet()) {
            printStream.println(String.format("(%s) %s", menuItem.getKey(), menuItem.getValue().description()));
        }

    }


    public void run() {
        String userInput;
        print();
        userInput = getUserInput();
        try {
            executeUserInput(userInput);
        } catch (QuitCommandException e) {
            amRunning = false;
        }
    }

    private void executeUserInput(String userInput) throws QuitCommandException {
        Command command = menuItems.get(userInput);
        if (command == null) {
            printStream.println("That is an invalid selection!");
        } else {
            command.execute();
        }
    }

    private String getUserInput() {

        printStream.println("Please Select an option from the Menu:");
        String userInput = "";

        try {
            userInput = reader.readLine();
            userInput = userInput.toUpperCase();
        } catch (IOException e) {
            printStream.println("Could not read user's input.");
        }

        return userInput;
    }

    public boolean isRunning() {
        return amRunning;
    }
}
