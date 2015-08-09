import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

/**
 * Created by cramsden on 8/5/15.
 */
public class BibliotecaLauncherTest {
    Library library;
    PrintStream printStream;
    BibliotecaLauncher bibliotecaLauncher;
    BufferedReader reader;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        reader = mock(BufferedReader.class);

        printStream = mock(PrintStream.class);

        menu = mock(Menu.class);
        bibliotecaLauncher = new BibliotecaLauncher(library, printStream, menu);

    }

    @Test
    public void shouldPrintWelcomeWhenLibraryOpens() throws IOException {
        bibliotecaLauncher.runLibrary();
        verify(library).open();

    }

    @Test
    public void shouldPrintMenuWhenLibraryOpens() throws IOException {

        bibliotecaLauncher.runLibrary();

        verify(menu).print();
    }

}