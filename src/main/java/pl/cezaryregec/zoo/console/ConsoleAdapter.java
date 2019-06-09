package pl.cezaryregec.zoo.console;

public interface ConsoleAdapter<ActionIndex extends Enum<ActionIndex>> {
    boolean isRunning();
    void shutDown();
    void nextCommand();
    void execute(ActionIndex index);
}
