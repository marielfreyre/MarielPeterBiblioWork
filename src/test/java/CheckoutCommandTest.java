import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by ptang on 8/7/15.
 */
public class CheckoutCommandTest {

    private Command checkoutCommand;
    private Library library;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        checkoutCommand = new CheckoutCommand(library);
    }

    @Test
    public void shouldGiveDescriptionWhenRequested() throws Exception {

        assertThat(checkoutCommand.description(), is("Checkout books"));

    }

    @Test
    public void shouldCallLibraryCheckoutWhenExecuted() throws Exception {
        checkoutCommand.execute();
        verify(library).checkOutBook();

    }
    
}
