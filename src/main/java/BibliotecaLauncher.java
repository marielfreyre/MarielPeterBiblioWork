import java.io.PrintStream;

/**
 * Created by cramsden on 8/5/15.
 */
public class BibliotecaLauncher {
    private Library library;
    Menu menu;

    public BibliotecaLauncher(Library library, PrintStream printStream, Menu menu) {
        this.library = library;
        this.menu = menu;
    }

    private void openLibrary() {
        library.open();
    }


    public void runLibrary() {
        openLibrary();

        while (menu.isRunning()) {
            menu.run();
        }
    }


}
