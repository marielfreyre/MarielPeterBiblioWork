/**
 * Created by cramsden on 8/5/15.
 */
public interface Command {
    public void execute() throws QuitCommandException;
    public String description();

}
