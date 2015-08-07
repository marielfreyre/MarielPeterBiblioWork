import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by cramsden on 8/5/15.
 */
public class QuitCommandTest {
    private QuitCommand quitCommand;
    private Console console;

    @Before
    public void setUp() throws Exception {
        console = mock(Console.class);
        quitCommand = new QuitCommand(console);
    }

    /*
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

    }*/


    @Test
    public void shouldGiveCommandNameWhenRequested() throws Exception {
        assertThat(quitCommand.description(),is("Quit"));


    }

    @Test
    public void shouldCallConsoleQuitWhenCommandExecute() {
        QuitCommandException quitCommandException = null;
        try {
            quitCommand.execute();
        } catch (QuitCommandException e) {
            quitCommandException = e;
        }

        assertNotNull(quitCommandException);

//        verify(console).quit();

    }
}
