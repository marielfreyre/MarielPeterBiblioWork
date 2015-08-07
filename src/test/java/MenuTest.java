import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by mfreyre on 8/6/15.
 */
public class MenuTest {


    private Console console;
    private Menu menu;
    private PrintStream printStream;
    private Map<String, Command> menuItems;
    private Command command;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        menuItems = new HashMap<>();
        command = mock(Command.class);
        menuItems.put("c", command);
    }

    @Test
    public void shouldGenerateMenu() throws Exception {
        menu = new Menu(printStream,menuItems);
        when(command.description()).thenReturn("Do command");
        menu.print();
        verify(printStream).println("(c) Do command");

    }


}
