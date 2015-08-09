import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

/**
 * Created by cramsden on 8/5/15.
 */
public class QuitCommandTest {
    private QuitCommand quitCommand;

    @Before
    public void setUp() throws Exception {
        quitCommand = new QuitCommand();
    }

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

    }
}
