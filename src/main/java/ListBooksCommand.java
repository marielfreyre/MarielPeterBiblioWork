/**
 * Created by cramsden on 8/5/15.
 */
public class ListBooksCommand implements Command{
    private Console console;

    public ListBooksCommand(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.listAllBooks();
    }

    @Override
    public String description() {
        return "List Books";
    }
}
