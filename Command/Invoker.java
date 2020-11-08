package Command;

public class Invoker {
    private Command command;

    public Invoker() {
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke() {
        command.execute();
    }
}
