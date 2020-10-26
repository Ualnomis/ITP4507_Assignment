package Factory;
import Command.*;

public abstract class CommandFactory {
    public Receiver receiver = new Receiver();
    public Invoker invoker = new Invoker();
    public abstract Command createCommand();
}
