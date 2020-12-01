package Command;

public class Invoker {
    private Command command; // command

    // no args constructor
    public Invoker() {
    }

    // set command
    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke() {
        command.execute(); // call commmand execute method to execute command
    }
}
