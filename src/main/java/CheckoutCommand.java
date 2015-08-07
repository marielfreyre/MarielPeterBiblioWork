/**
 * Created by ptang on 8/7/15.
 */
public class CheckoutCommand implements Command {
    private Library library;

    public CheckoutCommand(Library library) {

        this.library = library;
    }

    @Override
    public void execute() throws QuitCommandException {
        library.checkOutBook();
    }

    @Override
    public String description() {
        return "Checkout books";
    }
}
