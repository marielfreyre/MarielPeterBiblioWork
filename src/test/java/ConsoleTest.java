import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
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
    private Map<String,Command> menuItems;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        reader = mock(BufferedReader.class);
        when(library.open()).thenReturn("Welcome to the Library! Biblioteca is available!");
        List<Book> books = new ArrayList<>();
        book = mock(Book.class);
        books.add(book);
        //when(library.listAllBooks()).thenReturn(books);
        listBooksCommand = mock(ListBooksCommand.class);
        menuItems = new HashMap<>();
        menuItems.put("1",listBooksCommand);
        output = mock(PrintStream.class);
        console = new Console(library,output, reader,menuItems);

    }

    @Test
    public void shouldPrintWelcomeWhenLibraryOpens() {

        console.runLibrary();
        verify(output).println(library.open());

    }



//    @Test
//    public void shouldGenerateMenu() throws Exception {
//        console.runLibrary();
//        verify(output, times(1)).println(anyString());
//
//    }


//    @Test
//    public void shouldListBooksWhenUserChoosesListBooks() throws Exception {
//        when(reader.readLine()).thenReturn("1").thenReturn("nanana");
//        console.runLibrary();
//        verify(listBooksCommand).execute();
//    }
//
//    @Test
//    public void shouldPrintInvalidMessageWhenUserInputIsIncorrect() throws Exception {
//        when(reader.readLine()).thenReturn("!!!");
//        console.runLibrary();
//        verify(output).println(contains("That is an invalid selection!"));
//
//    }

}
