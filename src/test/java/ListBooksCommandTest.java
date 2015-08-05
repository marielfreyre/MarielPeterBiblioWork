import junit.framework.TestCase;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by cramsden on 8/5/15.
 */
public class ListBooksCommandTest {
    private ListBooksCommand booksCommand;

    @Test
    public void shouldListBooksWhenCommandExecute() throws Exception {
        Console console = mock(Console.class);
        booksCommand = new ListBooksCommand(console);
        booksCommand.execute();
        verify(console).listAllBooks();

    }

    @Test
    public void shouldGiveCommandNameWhenRequested() throws Exception {
        booksCommand = new ListBooksCommand(mock(Console.class));
        assertThat(booksCommand.description(),is("List Books"));


    }
}