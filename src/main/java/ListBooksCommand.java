import java.io.PrintStream;

/**
 * Created by cramsden on 8/5/15.
 */
public class ListBooksCommand implements Command{
    private Library library;
    private PrintStream printStream;

    public ListBooksCommand(Library library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }



    @Override
    public void execute() {
        library.listAllBooks();
    }


    @Override
    public String description() {
        return "List Books";
    }
}
