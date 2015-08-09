import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * Created by mfreyre on 8/6/15.
 */
public class MenuTest {

    private Menu menu;
    private PrintStream printStream;
    private Map<String, Command> menuItems;
    private Command command;
    private BufferedReader reader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        menuItems = new HashMap<>();
        command = mock(Command.class);
        menuItems.put("c", command);
        reader = mock(BufferedReader.class);
        menu = new Menu(printStream,menuItems, reader);

    }

    @Test
    public void shouldGenerateMenu() throws Exception {
        when(command.description()).thenReturn("Do command");
        menu.print();
        verify(printStream).println("(c) Do command");

    }


}
