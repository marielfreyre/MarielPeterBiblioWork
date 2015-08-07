/**
 * Created by cramsden on 8/5/15.
 */
public class QuitCommand implements Command {

    private Console console;

    public QuitCommand(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.quit();
    }

    @Override
    public String description() {
        return "Quit";
    }
}
