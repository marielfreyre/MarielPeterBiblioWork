import java.io.PrintStream;
import java.util.Map;

/**
 * Created by mfreyre on 8/7/15.
 */
public class Menu {

    private PrintStream printStream;
    private Map<String, Command> menuItems;

    public Menu(PrintStream printStream, Map<String, Command> menuItems) {

        this.printStream = printStream;
        this.menuItems = menuItems;
    }

    public void print() {

        for (Map.Entry<String, Command> menuItem : menuItems.entrySet()) {
            printStream.println(String.format("(%s) %s", menuItem.getKey(), menuItem.getValue().description()));
        }

    }
}
