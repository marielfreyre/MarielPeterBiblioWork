import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by cramsden on 8/5/15.
 */
public class QuitCommandTest {
    private ListBooksCommand booksCommand;

    @Test
    public void shouldListBooksWhenCommandExecute() throws Exception {
        Library library = mock(Library.class);
        PrintStream printStream = mock(PrintStream.class);
        booksCommand = new ListBooksCommand(library, printStream);
        booksCommand.execute();
        verify(library).listAllBooks();

    }

    @Test
    public void shouldGiveCommandNameWhenRequested() throws Exception {
        booksCommand = new ListBooksCommand(mock(Library.class), mock(PrintStream.class));
        assertThat(booksCommand.description(),is("List Books"));


    }
}
