import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

/**
 * Created by cramsden on 8/5/15.
 */
public class ConsoleTest {
    Library library;
    PrintStream printStream;
    Console console;
    BufferedReader reader;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        reader = mock(BufferedReader.class);

        printStream = mock(PrintStream.class);

        menu = mock(Menu.class);
        console = new Console(library, printStream, menu);

    }

    @Test
    public void shouldPrintWelcomeWhenLibraryOpens() throws IOException {
        when(library.open()).thenReturn("Welcome to the Library! Biblioteca is available!");

        console.runLibrary();
        verify(printStream).println(library.open());

    }

    @Test
    public void shouldPrintMenuWhenLibraryOpens() throws IOException {

        console.runLibrary();

        verify(printStream).println(library.open());
    }

}