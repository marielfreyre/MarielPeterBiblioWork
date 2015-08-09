import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by ptang on 8/9/15.
 */
public class ReturnCommandTest {

    private Library library;
    private Command returnCommand;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        returnCommand = new ReturnCommand(library);
    }

    @Test
    public void shouldGiveDescriptionOfCommandWhenRequested() throws Exception {

        assertThat(returnCommand.description(), is("Return a book to the library"));

    }

    @Test
    public void shouldCallLibraryReturnBooksWhenExecuted() throws Exception {
        returnCommand.execute();

        verify(library).returnBook();

    }
}
