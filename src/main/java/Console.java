import java.io.PrintStream;

/**
 * Created by cramsden on 8/5/15.
 */
public class Console {
    private Library library;
    private PrintStream printStream;
    Menu menu;

    public Console(Library library, PrintStream printStream, Menu menu) {
        this.library = library;
        this.printStream = printStream;
        this.menu = menu;
    }

    private void openLibrary() {
        printStream.println(library.open());
    }


    public void runLibrary() {
        openLibrary();

        while (menu.isRunning()) {
            menu.run();
        }
    }


}
