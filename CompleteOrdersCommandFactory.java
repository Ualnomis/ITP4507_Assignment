public class CompleteOrdersCommandFactory extends CommandFactory {
    public Command createCommand() {
        return new CompleteOrdersCommand(super.getReceiver(), super.getOrders());
    } 
}
