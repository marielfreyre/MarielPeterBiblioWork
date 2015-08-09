/**
 * Created by cramsden on 8/5/15.
 */
public class QuitCommand implements Command {

    @Override
    public void execute() throws QuitCommandException {
        throw new QuitCommandException();
    }

    @Override
    public String description() {
        return "Quit";
    }
}
