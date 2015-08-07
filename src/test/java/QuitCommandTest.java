import org.junit.Test;
import org.mockito.internal.verification.Times;

import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by cramsden on 8/5/15.
 */
public class QuitCommandTest {
    private ListBooksCommand booksCommand1;
    private ListBooksCommand booksCommand2;
    private QuitCommand booksCommand3;


    @Test
    public void shouldQuitProgramWhenCommandExecute() throws Exception {
        Library library = mock(Library.class);
        PrintStream printStream = mock(PrintStream.class);
        Console console = mock(Console.class);
        booksCommand1 = new ListBooksCommand(library, printStream);
        booksCommand1.execute();
        booksCommand2 = new ListBooksCommand(library, printStream);
        booksCommand2.execute();
        booksCommand3 = new QuitCommand();
        booksCommand3.execute();
        //assertThat(console.getUserInput(), times(3));

    }


    @Test
    public void shouldGiveCommandNameWhenRequested() throws Exception {
        booksCommand1 = new ListBooksCommand(mock(Library.class), mock(PrintStream.class));
        assertThat(booksCommand1.description(),is("List Books"));


    }
}
