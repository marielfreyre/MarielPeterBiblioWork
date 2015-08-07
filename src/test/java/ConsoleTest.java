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
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by cramsden on 8/5/15.
 */
public class ConsoleTest {
    Library library;
    PrintStream output;
    Console console;
    Book book;
    BufferedReader reader;
    private ListBooksCommand listBooksCommand;
    private Map<String, Command> menuItems;
    private QuitCommand quitCommand;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        reader = mock(BufferedReader.class);

        List<Book> books = new ArrayList<>();
        book = mock(Book.class);
        books.add(book);

        listBooksCommand = mock(ListBooksCommand.class);
        menuItems = new HashMap<>();
        menuItems.put("1", listBooksCommand);

        output = mock(PrintStream.class);


        menu = new Menu(output, menuItems);
        console = new Console(library, output, reader, menuItems, menu);
        quitCommand = new QuitCommand(console);
        menuItems.put("q", quitCommand);

    }

    @Test
    public void shouldPrintWelcomeWhenLibraryOpens() throws IOException {
        when(library.open()).thenReturn("Welcome to the Library! Biblioteca is available!");
        when(reader.readLine()).thenReturn("q");

        console.runLibrary();
        verify(output).println(library.open());

    }

    @Test
    public void shouldPrintMenuWhenLibraryOpens() throws IOException {
        menu = mock(Menu.class);
        console = new Console(library, output, reader, menuItems, menu);
        when(reader.readLine()).thenReturn("q");

        console.runLibrary();
    /*    for (Map.Entry<String, Command> commandEntry : menuItems.entrySet()) {
            verify(commandEntry.getValue()).description();
        }*/

        verify(menu).print();
    }

}